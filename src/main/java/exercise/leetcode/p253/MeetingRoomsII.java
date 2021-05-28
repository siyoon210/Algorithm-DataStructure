package exercise.leetcode.p253;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given an array of meeting time intervals consisting of start and end
 * times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of
 * conference rooms required.
 * <p>
 * Input: [[0,30],[5,10],[15,20]]
 * Output: 2
 * <p>
 * Input: [[7,10],[2,4]]
 * Output: 1
 */

class Room {
    List<int[]> bookedTimeIntervals = new ArrayList<>();

    boolean isAvailable(int[] interval) {
        for (int[] bookedTimeInterval : bookedTimeIntervals) {
            if (isOverlap(interval, bookedTimeInterval)) {
                return false;
            }
        }

        return true;
    }

    private boolean isOverlap(int[] interval, int[] bookedTimeInterval) {
        return (interval[0] >= bookedTimeInterval[0] && interval[0] <= bookedTimeInterval[1])
                || (interval[1] >= bookedTimeInterval[0] && interval[1] <= bookedTimeInterval[1]);
    }
}

class Solution {
    int getMinNumberOfRoom(int[][] intervals) {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room());

        for (int[] interval : intervals) {
            if (!ifPossibleToBookAtExistedRoomsAdd(rooms, interval)) {
                Room newRoom = new Room();
                newRoom.bookedTimeIntervals.add(interval);
                rooms.add(newRoom);
            }
        }

        return rooms.size();
    }

    private boolean ifPossibleToBookAtExistedRoomsAdd(List<Room> rooms, int[] interval) {
        for (Room room : rooms) {
            if (room.isAvailable(interval)) {
                room.bookedTimeIntervals.add(interval);
                return true;
            }
        }

        return false;
    }
}

/**
 * 최악의 경우 n개의 인터벌들이 (1 ~ n-1)번 순회해야 하므로 시간복잡도 O(n^2)
 * (1번탐색 + 2번탐색 + ... + n-1번탐색 + n번탐색 = n^2 + 1 / 2)
 */
public class MeetingRoomsII {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] intervals1 = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals2 = new int[][]{{7, 10}, {2, 4}};

        assertThat(solution.getMinNumberOfRoom(intervals1)).isEqualTo(2);
        assertThat(solution.getMinNumberOfRoom(intervals2)).isEqualTo(1);
    }
}
