package exercise.leetcode.p912;

import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}

public class SortAnArray {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};

        Solution solution = new Solution();
        for (int i : solution.sortArray(nums)) {
            System.out.println(i);
        }
    }
}
