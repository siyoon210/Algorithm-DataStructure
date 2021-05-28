package exercise.leetcode.p1277;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int countSquares(int[][] matrix) {
        int answer = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    int min = min(getValue(matrix, i - 1, j - 1), getValue(matrix, i - 1, j), getValue(matrix, i, j - 1));
                    matrix[i][j] = min + 1;
                }

                answer += matrix[i][j];
            }
        }

        return answer;
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    private int getValue(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return 0;
        }

        return matrix[i][j];
    }
}

public class P1277 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.countSquares(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        })).isEqualTo(15);

        assertThat(solution.countSquares(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        })).isEqualTo(7);

        out.println("p1277" + " success!");
    }
}
