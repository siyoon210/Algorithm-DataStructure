package exercise.leetcode.p1480;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        runningSum[0] = nums[0];

        for (int i = 1; i < runningSum.length; i++) {
            runningSum[i] = runningSum[i - 1] + nums[i];
        }

        return runningSum;
    }
}

public class P1480 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        assertThat(solution.runningSum(new int[]{1,2,3,4})).isEqualTo(new int[]{1,3,6,10});
        assertThat(solution.runningSum(new int[]{1,1,1,1,1})).isEqualTo(new int[]{1,2,3,4,5});

        out.println("p1480" + " success!");
    }
}
