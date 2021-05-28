package exercise.leetcode.p494;

class Solution {
    private int count;
    private int targetSum;
    private int[] nums;

    Solution() {
        count = 0;
    }

    public int findTargetSumWays(int[] nums, int S) {
        this.targetSum = S;
        this.nums = nums;
        calcNums( 0, 0);

        return count;
    }

    private void calcNums(int index, int sum) {
        if (index >= nums.length) {
            if (targetSum == sum) {
                count++;
            }
            return;
        }

        //더하는 경우
        sum += nums[index];
        calcNums(index + 1, sum);
        sum -= nums[index];

        //빼는 경우
        sum -= nums[index];
        calcNums(index + 1, sum);
    }
}

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;

        Solution solution = new Solution();
        System.out.println("solution.findTargetSumWays(nums, S) = " + solution.findTargetSumWays(nums, S));
    }
}
