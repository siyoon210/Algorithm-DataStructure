package exercise.leetcode.p26;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 0) {
            return nums.length;
        }

        int pointer1 = 0;
        int pointer2 = 1;

        try {
            while (pointer2 < nums.length) {
                if (nums[pointer1] == nums[pointer2]) {
                    do {
                        pointer2++;
                    } while (nums[pointer1] == nums[pointer2]);

                    swap(nums, pointer1, pointer2);
                }

                pointer1++;
                pointer2++;
            }
        } catch (Exception ignored) {}

        nums = Arrays.copyOfRange(nums, 0, pointer1 + 1);

        return nums.length;
    }

    private void swap(final int[] nums, final int pointer1, final int pointer2) {
        int tmp = nums[pointer1 + 1];
        nums[pointer1 + 1] = nums[pointer2];
        nums[pointer2] = tmp;
    }
}

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums3 = {};
        int[] nums4 = {1, 1};
        int[] nums5 = {1, 1, 2, 3};

        assertThat(solution.removeDuplicates(nums1)).isEqualTo(2);
        assertThat(solution.removeDuplicates(nums2)).isEqualTo(5);
        assertThat(solution.removeDuplicates(nums3)).isEqualTo(0);
        assertThat(solution.removeDuplicates(nums4)).isEqualTo(1);
        assertThat(solution.removeDuplicates(nums5)).isEqualTo(3);
        System.out.println("End");
    }
}
