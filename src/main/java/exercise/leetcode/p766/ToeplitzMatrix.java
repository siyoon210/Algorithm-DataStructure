package exercise.leetcode.p766;

class Solution {
    private int[][] matrix;
    private boolean isToeplitz;

    Solution(int[][] matrix) {
        this.matrix = matrix;
        this.isToeplitz = true;
    }

    public boolean isToeplitzMatrix() {
        for (int i = matrix.length - 1; i >= 0; i--) {
            if (!isToeplitz) {
                break;
            }

            isToeplitz(i, 0);
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (!isToeplitz) {
                break;
            }

            isToeplitz(0, i);
        }

        return isToeplitz;
    }

    private void isToeplitz(int i, int j) {
        int firstValue = matrix[i][j];

        isToeplitz(firstValue, i + 1, j + 1);
    }

    private void isToeplitz(int firstValue, int i, int j) {
        if (!isValidCoordinate(i, j)) {
            return;
        }

        if (firstValue != matrix[i][j]) {
            isToeplitz = false;
            return;
        }

        isToeplitz(firstValue, i + 1, j + 1);
    }

    private boolean isValidCoordinate(int i, int j) {
        return (i < matrix.length && i > 0) && (j < matrix[0].length && j > 0);
    }
}

public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}
        };

        Solution solution = new Solution(matrix);
        System.out.println(solution.isToeplitzMatrix());
    }
}
