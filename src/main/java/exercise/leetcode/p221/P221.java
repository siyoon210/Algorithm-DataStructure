package exercise.leetcode.p221;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int answer = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }

                int min = min(getValue(matrix, i - 1, j - 1), getValue(matrix, i, j - 1), getValue(matrix, i - 1, j));

                matrix[i][j] = (char) ((min + 1) + '0');
                answer = Math.max(answer, (min + 1) * (min + 1));
            }
        }

        return answer;
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    private int getValue(char[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return 0;
        }

        return matrix[i][j] - '0';
    }
}

public class P221 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        })).isEqualTo(4);

        out.println("p221" + " success!");
    }
}
