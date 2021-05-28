package exercise.programmers.p42898;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] roads = new int[n][m];
        roads[0][0] = 1;
        for (int[] puddle : puddles) {
            roads[puddle[0] - 1][puddle[1] - 1] = -1;
        }

        for (int i = 0; i < roads.length; i++) {
            for (int j = 0; j < roads[i].length; j++) {
                if (roads[i][j] < 0) {
                    continue;
                }

                int leftValue = getLeftValue(roads, i, j);
                int topValue = getTopValue(roads, i, j);
                roads[i][j] += leftValue + topValue;
            }
        }

        for (int[] road : roads) {
            for (int i : road) {
                out.print(i +" ");
            }
            out.println();
        }
        out.println();

        return roads[n - 1][m - 1] % 1_000_000_007;
    }

    private int getLeftValue(int[][] roads, int i, int j) {
        final int leftIndexJ = j - 1;
        if (leftIndexJ < 0) {
            return 0;
        }

        return Math.max(roads[i][leftIndexJ], 0);
    }

    private int getTopValue(int[][] roads, int i, int j) {
        final int topIndexI = i - 1;
        if (topIndexI < 0) {
            return 0;
        }

        return Math.max(roads[topIndexI][j], 0);
    }
}

public class P42898 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(4, 3, new int[][]{{2, 2}})).isEqualTo(4);
        assertThat(solution.solution(4, 3, new int[][]{{2, 2}, {2, 3}})).isEqualTo(2);
        assertThat(solution.solution(4, 3, new int[][]{{2, 1}, {2, 2}, {2, 3}})).isEqualTo(1);

        out.println("p42898" + " success!");
    }
}
