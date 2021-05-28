package exercise.leetcode.p561;

import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        for (int i = 0; i < nums.length; i += 2) {
            answer += nums[i];
        }

        return answer;
    }
}

public class ArrayPartitionI {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};

        Solution solution = new Solution();
        System.out.println(solution.arrayPairSum(nums));
    }
}
