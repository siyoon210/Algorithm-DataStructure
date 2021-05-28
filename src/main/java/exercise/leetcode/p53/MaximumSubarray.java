package exercise.leetcode.p53;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        if (nums == null || nums.length == 0) {
            return max;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                max = nums[i];
                continue;
            }
            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})).isEqualTo(6);

        out.println("p53" + " success!");
    }
}
