package exercise.leetcode.p1051;

class Solution {
    public int heightChecker(int[] heights) {
        int wrongPositionCount = 0;

        if (heights[0] > heights[1]) {
            wrongPositionCount++;
        }

        for (int i = 1; i < heights.length - 1; i++) {
            if ((heights[i] < heights[i - 1]) || (heights[i + 1] < heights[i])) {
                wrongPositionCount++;
            }
        }

        if (heights[heights.length - 2] > heights[heights.length - 1]) {
            wrongPositionCount++;
        }

        return wrongPositionCount;
    }
}

public class HeightChecker {
    public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3};

        Solution solution = new Solution();
        System.out.println("solution.heightChecker(heights) = " + solution.heightChecker(heights));
    }
}
