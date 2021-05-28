package exercise.leetcode.p136;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
//        public int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//
//        if (nums.length == 1 || nums[0] != nums[1]) {
//            return nums[0];
//        }
//
//        for (int i = 1; i < nums.length - 1; i++) {
//            if (nums[i] == nums[i - 1]) {
//                continue;
//            }
//
//            if (nums[i] == nums[i + 1]) {
//                continue;
//            }
//
//            return nums[i];
//        }
//
//        return nums[nums.length - 1];
//    }

    public int singleNumber(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            answer ^= nums[i];
        }

        return answer;
    }
}

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums1 = {2, 2, 1};
        int[] nums2 = {4, 1, 2, 1, 2};

        Solution solution = new Solution();
        assertThat(solution.singleNumber(nums1)).isEqualTo(1);
        assertThat(solution.singleNumber(nums2)).isEqualTo(4);
    }
}
