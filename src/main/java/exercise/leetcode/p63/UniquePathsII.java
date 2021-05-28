package exercise.leetcode.p63;

class Solution {
    private int uniquePathCount;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        uniquePathCount = 0;

        // 탐색
        calcUniquePath(0, 0, obstacleGrid);

        return uniquePathCount;
    }

    private void calcUniquePath(int i, int j, int[][] obstacleGrid) {
        if (!validateCoordinate(i, j, obstacleGrid)) {
            return;
        }

        if (isObstacle(obstacleGrid[i][j])) {
            return;
        }

        if (isFinished(i, j, obstacleGrid)) {
            uniquePathCount++;
            return;
        }



        calcUniquePath(i, j + 1, obstacleGrid);
        calcUniquePath(i + 1, j, obstacleGrid);
    }

    private boolean isObstacle(int i) {
        return i == 1;
    }

    private boolean validateCoordinate(int i, int j, int[][] obstacleGrid) {
        return (i >= 0 && i < obstacleGrid.length) && (j >= 0 && j < obstacleGrid[0].length);
    }

    private boolean isFinished(int i, int j, int[][] obstacleGrid) {
        return (i == obstacleGrid.length - 1) && (j == obstacleGrid[0].length - 1);
    }
}

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {1}
        };

        Solution solution = new Solution();
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }
}
