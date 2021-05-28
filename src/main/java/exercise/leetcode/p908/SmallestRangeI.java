package exercise.leetcode.p908;

class Solution {
    public int smallestRangeI(int[] A, int K) {
        int minValuOfTheMaxValueOfTheElementRangeValue = Integer.MAX_VALUE;
        int maxValuOfTheMinValueOfTheElementRangeValue = Integer.MIN_VALUE;

        for (int i : A) {
            minValuOfTheMaxValueOfTheElementRangeValue = Math.min(minValuOfTheMaxValueOfTheElementRangeValue, i + K);
            maxValuOfTheMinValueOfTheElementRangeValue = Math.max(maxValuOfTheMinValueOfTheElementRangeValue, i - K);
        }

        int gap = maxValuOfTheMinValueOfTheElementRangeValue - minValuOfTheMaxValueOfTheElementRangeValue;
        return gap < 0 ? 0 : gap;
    }
}

public class SmallestRangeI {
    public static void main(String[] args) {
        int[] A = {1, 3, 6};
        int K = 3;

        Solution solution = new Solution();
        System.out.println(solution.smallestRangeI(A, K));
    }
}
