package exercise.leetcode.p62;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    int[][] ints;

    public int uniquePaths(int m, int n) {
        ints = new int[m][n];

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if (i == 0 && j == 0) {
                    ints[i][j] = 1;
                    continue;
                }

                int path = 0;

                if (isValidIndex(i, j - 1)) {
                    path += ints[i][j - 1];
                }

                if (isValidIndex(i - 1, j)) {
                    path += ints[i - 1][j];
                }

                ints[i][j] = path;
            }
        }

        return ints[m - 1][n - 1];
    }

    private boolean isValidIndex(int i, int j) {
        return (i >= 0) && (j >= 0);
    }
}

public class P62 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.uniquePaths(3, 2)).isEqualTo(3);
        assertThat(solution.uniquePaths(7, 3)).isEqualTo(28);

        out.println("p62" + " success!");
    }
}
