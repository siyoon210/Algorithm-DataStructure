package exercise.leetcode.p198;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    // N번째의 최대값 = N+1번째의 최대값 vs N+2번쨰의 최대값 + N번째의 값
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                continue;
            }

            if (i == 1) {
                nums[i] = Math.max(nums[i - 1], nums[i]);
                continue;
            }

            nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);
        }

        return nums[nums.length - 1];
    }
}

public class P198 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.rob(new int[]{1, 2, 3, 1})).isEqualTo(4);
        assertThat(solution.rob(new int[]{2, 7, 9, 3, 1})).isEqualTo(12);
        assertThat(solution.rob(new int[]{2, 1, 1, 2})).isEqualTo(4);

        out.println("p198" + " success!");
    }
}
