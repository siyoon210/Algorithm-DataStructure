package exercise.leetcode.p303;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumArray {
    private final int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length];

        if (nums.length == 0) {
            return;
        }

        sum[0] = nums[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sum[j];
        }
        return sum[j] - sum[i - 1];
    }
}

public class P303 {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        assertThat(numArray.sumRange(0, 2)).isEqualTo(1); // return 1 ((-2) + 0 + 3)
        assertThat(numArray.sumRange(2, 5)).isEqualTo(-1); // return -1 (3 + (-5) + 2 + (-1))
        assertThat(numArray.sumRange(0, 5)).isEqualTo(-3); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
    }
}
