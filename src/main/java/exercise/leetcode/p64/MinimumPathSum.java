package exercise.leetcode.p64;

class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int leftValue = getValue(grid, i - 1, j);
                int upValue = getValue(grid, i, j - 1);

                if (leftValue == -1 && upValue == -1) {
                    continue;
                } else if (leftValue == -1) {
                    grid[i][j] += upValue;
                } else if (upValue == -1) {
                    grid[i][j] += leftValue;
                } else {
                    int min = Math.min(leftValue, upValue);
                    grid[i][j] += min;
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

    private int getValue(int[][] grid, int i, int j) {
        if ((i < 0 || grid.length <= i) || (j < 0 || grid[0].length <= j)) {
            return -1; //given value is non-negative value
        }

        return grid[i][j];
    }
}

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] gird = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        Solution solution = new Solution();
        System.out.println(solution.minPathSum(gird));
    }
}
