package exercise.leetcode.p300;

import java.util.Arrays;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int lis = 1;

        if (nums.length == 1) {
            return lis;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            lis = Math.max(lis, dp[i]);
        }

        return lis;
    }
}

public class P300 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})).isEqualTo(4);
        assertThat(solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3})).isEqualTo(4);
        assertThat(solution.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7, 7})).isEqualTo(1);

        out.println("p300" + " success!");
    }
}
