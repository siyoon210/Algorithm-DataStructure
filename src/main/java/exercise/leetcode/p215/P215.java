package exercise.leetcode.p215;

import java.util.Arrays;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

public class P215 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        assertThat(solution.findKthLargest(new int[]{3,2,1,5,6,4}, 2)).isEqualTo(5);
        assertThat(solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4)).isEqualTo(4);

        out.println("p215" + " success!");
    }
}
