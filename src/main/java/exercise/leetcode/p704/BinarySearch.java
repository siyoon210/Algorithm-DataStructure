package exercise.leetcode.p704;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int search(int[] nums, int target) {
        int index;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            index = left + (right - left) / 2;

            if (nums[index] == target) {
                return index;
            }

            if (target < nums[index]) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return -1;
    }
}

public class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9)).isEqualTo(4);
        assertThat(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 2)).isEqualTo(-1);
        assertThat(solution.search(new int[]{5}, -5)).isEqualTo(-1);
        assertThat(solution.search(new int[]{2, 5}, 5)).isEqualTo(1);
    }
}
