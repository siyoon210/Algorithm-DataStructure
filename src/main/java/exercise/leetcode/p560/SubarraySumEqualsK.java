package exercise.leetcode.p560;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int answer = 0;

        for (int subArraLength = 1; subArraLength <= nums.length; subArraLength++) {
            int from = 0;
            while (from < nums.length) {
                final int to = from + subArraLength;
                if (to > nums.length) {
                    break;
                }
                final int[] ints = Arrays.copyOfRange(nums, from, to);
                from++;

                int subSum = 0;
                for (final int anInt : ints) {
                    subSum += anInt;
                }

                if (subSum == k) {
                    answer++;
                }
            }
        }
        return answer;
    }
}

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 1, 1};
        int k1= 2;

        int[] nums2 = {1, 2, 3, 4, 5};
        int k2= 9;

        assertThat(solution.subarraySum(nums1, k1)).isEqualTo(2);
        assertThat(solution.subarraySum(nums2, k2)).isEqualTo(2);
    }
}
