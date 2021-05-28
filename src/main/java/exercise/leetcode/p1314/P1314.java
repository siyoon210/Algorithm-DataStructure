package exercise.leetcode.p1314;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    static class Range {
        int rMin;
        int rMax;
        int cMin;
        int cMax;

        public Range(int rMin, int rMax, int cMin, int cMax) {
            this.rMin = rMin;
            this.rMax = rMax;
            this.cMin = cMin;
            this.cMax = cMax;
        }

        public int calcSum(int[][] mat) {
            int sum = 0;
            for (int i = rMin; i <= rMax; i++) {
                for (int j = cMin; j <= cMax; j++) {
                    sum += mat[i][j];
                }
            }
            return sum;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Range)) return false;

            Range range = (Range) o;

            if (rMin != range.rMin) return false;
            if (rMax != range.rMax) return false;
            if (cMin != range.cMin) return false;
            return cMax == range.cMax;
        }

        @Override
        public int hashCode() {
            int result = rMin;
            result = 31 * result + rMax;
            result = 31 * result + cMin;
            result = 31 * result + cMax;
            return result;
        }

        @Override
        public String toString() {
            return "Range{" +
                    "rMin=" + rMin +
                    ", rMax=" + rMax +
                    ", cMin=" + cMin +
                    ", cMax=" + cMax +
                    '}';
        }
    }

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] answer = new int[mat.length][mat[0].length];
        Map<Range, Integer> calcedRanged = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                Range range = calcRange(mat, i, j, K);
                if (!calcedRanged.containsKey(range)) {
                    calcedRanged.put(range, range.calcSum(mat));
                }
                answer[i][j] = calcedRanged.get(range);
            }
        }

        return answer;
    }

    private Range calcRange(int[][] mat, int i, int j, int K) {
        int rMin = Math.max(i - K, 0);
        int rMax = Math.min(i + K, mat.length - 1);
        int cMin = Math.max(j - K, 0);
        int cMax = Math.min(j + K, mat[0].length - 1);

        return new Range(rMin, rMax, cMin, cMax);
    }
}

public class P1314 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1))
                .isEqualTo(new int[][]{{12, 21, 16}, {27, 45, 33}, {24, 39, 28}});
        assertThat(solution.matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 2))
                .isEqualTo(new int[][]{{45, 45, 45}, {45, 45, 45}, {45, 45, 45}});

        out.println("p1314" + " success!");
    }
}
