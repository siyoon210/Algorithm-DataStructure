package exercise.leetcode.p152;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * House Robber유사문제
 */
class Solution {
    public int maxProduct(int[] nums) {
        int max = 0;
        if (nums == null || nums.length == 0) {
            return max;
        }

        int[] maxValues = new int[nums.length];
        int[] minValues = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                maxValues[0] = nums[0];
                minValues[0] = nums[0];
                max = maxValues[0];
                continue;
            }

            maxValues[i] = max(maxValues[i - 1] * nums[i], nums[i], minValues[i - 1] * nums[i]);
            minValues[i] = min(maxValues[i - 1] * nums[i], nums[i], minValues[i - 1] * nums[i]);
            max = Math.max(max, maxValues[i]);
        }

        return max;
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}

public class P152 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.maxProduct(new int[]{2, 3, -2, 4})).isEqualTo(6);
        assertThat(solution.maxProduct(new int[]{0, 2})).isEqualTo(2);
        assertThat(solution.maxProduct(new int[]{3, -1, 4})).isEqualTo(4);
        assertThat(solution.maxProduct(new int[]{2, 3, -2, -4})).isEqualTo(48);

        out.println("p152" + " success!");
    }
}
