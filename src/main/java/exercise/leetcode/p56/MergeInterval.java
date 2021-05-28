package exercise.leetcode.p56;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    static class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            if (this.start < o.start) {
                return -1;
            } else if (this.start > o.start) {
                return 1;
            }

            if (this.end < o.end) {
                return -1;
            } else if (this.end > o.end) {
                return 1;
            }

            return 0;
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }

        Collections.sort(intervalList);


        int i = 0;
        while (i < intervalList.size() - 1) {
            if (intervalList.get(i).end >= intervalList.get(i + 1).start) {
                int end = intervalList.get(i).end < intervalList.get(i + 1).end ? intervalList.get(i + 1).end : intervalList.get(i).end;
                Interval newInterval = new Interval(intervalList.get(i).start, end);
                intervalList.remove(i + 1);
                intervalList.remove(i);
                intervalList.add(i, newInterval);
                i = 0;
                continue;
            }
            i++;
        }


        int[][] answer = new int[intervalList.size()][2];

        for (int i1 = 0; i1 < intervalList.size(); i1++) {
            answer[i1][0] = intervalList.get(i1).start;
            answer[i1][1] = intervalList.get(i1).end;
        }

        return answer;
    }
}

public class MergeInterval {
    public static void main(String[] args) {
        int[][] intervals1 = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals2 = new int[][]{{1, 4}, {4, 5}};
        int[][] intervals3 = new int[][]{{1, 4}, {2, 3}};
        int[][] intervals4 = new int[][]{{1, 4}, {0, 2}, {3, 5}};

        Solution solution = new Solution();
        assertThat(solution.merge(intervals1)).isEqualTo(new int[][]{{1, 6}, {8, 10}, {15, 18}});
        assertThat(solution.merge(intervals2)).isEqualTo(new int[][]{{1, 5}});
        assertThat(solution.merge(intervals3)).isEqualTo(new int[][]{{1, 4}});
        assertThat(solution.merge(intervals4)).isEqualTo(new int[][]{{0, 5}});
    }
}
