package exercise.leetcode.p883;

class Solution {
    public int projectionArea(int[][] grid) {
        int res = 0;
        int n = grid.length;

        int top = 0;
        int front = 0;
        int side = 0;

        int fmax = 0; //save the max num in each row
        int[] smax = new int[n];//save the max num in each column

        for (int i = 0 ; i < n ; i++){

            for (int j = 0  ; j < n ; j++){

                if (grid[i][j] != 0){
                    top++;
                }

                fmax = grid[i][j] > fmax ? grid[i][j] : fmax;

                if (j == n-1){
                    front += fmax;
                    fmax = 0;
                }

                smax[j] = grid[i][j] > smax[j] ? grid[i][j] : smax[j];

                if (i == n-1){
                    side += smax[j];
                }
            }
        }

        return res = top + front + side;
    }
}

public class ProjectionAreaOf3DShapes {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 2},
                {3, 4}
        };

        Solution solution = new Solution();
        System.out.println(solution.projectionArea(grid));
    }
}
