package exercise.leetcode.p628;

import java.util.Arrays;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int positiveThree = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        int negativeTwoAndPositiveThree = nums[nums.length - 1] * nums[0] * nums[1];

        return Math.max(positiveThree, negativeTwoAndPositiveThree);
    }
}

public class P628 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.maximumProduct(new int[]{1, 2, 3})).isEqualTo(6);
        assertThat(solution.maximumProduct(new int[]{1, 2, 3, 4})).isEqualTo(24);

        out.println("p628" + " success!");
    }
}
