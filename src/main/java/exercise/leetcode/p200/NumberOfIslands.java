package exercise.leetcode.p200;

class Solution {
    private char[][] grid;
    private int m;
    private int n;

    int numIslands(char[][] grid) {
        this.m = grid.length;
        if (m <= 0) {
            return 0;
        }
        this.n = grid[0].length;


        int numberOfIslands = 0;
        this.grid = grid;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                if (grid[i][j] == '1') {
                    grid[i][j] = 0;
                    numberOfIslands++;
                    checkAllAdjacentArea(i, j);
                }
            }
        }

        return numberOfIslands;
    }

    private void checkAdjacentArea(int i, int j) {

//        try {
//            c = grid[i][j];
//        } catch (ArrayIndexOutOfBoundsException e) {
//            return;
//        }
        if ((i < 0 || i >= m) || (j < 0 || j >= n)) {
            return;
        }

        if (grid[i][j] == '1') {
            grid[i][j] = 0;
            checkAllAdjacentArea(i, j);
        }
    }

    private void checkAllAdjacentArea(int i, int j) {
        checkAdjacentArea(i - 1, j);
        checkAdjacentArea(i, j + 1);
        checkAdjacentArea(i + 1, j);
        checkAdjacentArea(i, j - 1);
    }
}

public class NumberOfIslands {
    public static void main(String[] args) {
//        char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'},
//        };

        char[][] grid = {};
        Solution solution = new Solution();
        System.out.println(solution.numIslands(grid));
    }
}
