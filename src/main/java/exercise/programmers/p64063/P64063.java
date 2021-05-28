package exercise.programmers.p64063;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public long[] solution(long k, long[] roomNumbers) {
        long[] answer = new long[roomNumbers.length];
        Map<Long, Long> nextRoom = new HashMap<>();

        for (int i = 0; i < roomNumbers.length; i++) {
            final long wantedRoomNumber = roomNumbers[i];
            if (!nextRoom.containsKey(wantedRoomNumber)) {
                answer[i] = wantedRoomNumber;
                nextRoom.put(wantedRoomNumber, wantedRoomNumber + 1);
                continue;
            }

            answer[i] = findEmptyRoomNumber(nextRoom, wantedRoomNumber);
        }

        return answer;
    }

    private long findEmptyRoomNumber(Map<Long, Long> nextRoom, long wantedRoomNumber) {
        if (nextRoom.containsKey(wantedRoomNumber)) {
            long emptyRoomNumber = findEmptyRoomNumber(nextRoom, nextRoom.get(wantedRoomNumber));
            nextRoom.put(wantedRoomNumber, emptyRoomNumber);
            return emptyRoomNumber;
        }
        nextRoom.put(wantedRoomNumber, wantedRoomNumber + 1);
        return wantedRoomNumber;
    }
}

public class P64063 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(10, new long[]{1, 3, 4, 1, 3, 1})).isEqualTo(new long[]{1, 3, 4, 2, 5, 6});

        out.println("p64063" + " success!");
    }
}
