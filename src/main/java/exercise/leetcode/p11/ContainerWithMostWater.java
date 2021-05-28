package exercise.leetcode.p11;

class Solution {
    public int maxArea(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int maxArea = 0;

        while (leftPointer < rightPointer) {
            int presentArea = (rightPointer - leftPointer) * (Math.min(height[leftPointer], height[rightPointer]));
            maxArea = Math.max(maxArea, presentArea);

            if (height[leftPointer] <= height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return maxArea;
    }
}

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        Solution solution = new Solution();
        System.out.println("solution.maxArea(height) = " + solution.maxArea(height));
    }
}
