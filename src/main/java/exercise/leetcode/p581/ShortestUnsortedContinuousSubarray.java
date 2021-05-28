package exercise.leetcode.p581;

import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        int ptrLeft = 0;
        int ptrRight = nums.length - 1;

        while (ptrLeft < ptrRight) {
            if (nums[ptrLeft] != sortedNums[ptrLeft] && nums[ptrRight] != sortedNums[ptrRight]) {
                break;
            }

            if (nums[ptrLeft] == sortedNums[ptrLeft]) {
                ptrLeft++;
            }

            if (nums[ptrRight] == sortedNums[ptrRight]) {
                ptrRight--;
            }
        }

        return ptrLeft == ptrRight ? (ptrRight - ptrLeft) : (ptrRight - ptrLeft + 1);
    }
}
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        int[] nums = {1};

        Solution solution = new Solution();
        System.out.println("solution.findUnsortedSubarray(nums) = " + solution.findUnsortedSubarray(nums));
    }
}
