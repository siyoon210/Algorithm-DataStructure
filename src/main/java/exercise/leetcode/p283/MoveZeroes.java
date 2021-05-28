package exercise.leetcode.p283;

class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIndexPointer = adjustZeroIndexPointer(nums, 0);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && i > zeroIndexPointer) {
                swapValue(nums, zeroIndexPointer, i);
                zeroIndexPointer = adjustZeroIndexPointer(nums, zeroIndexPointer);
            }
        }
    }

    private int adjustZeroIndexPointer(int[] nums, int zeroIndexPointer) {
        for (int j = zeroIndexPointer; j < nums.length; j++) {
            if (nums[j] == 0) {
                zeroIndexPointer = j;
                return zeroIndexPointer;
            }
        }

        return nums.length;
    }

    private void swapValue(int[] nums, int zeroIndexPointer, int i) {
        int tmp = nums[i];
        nums[i] = nums[zeroIndexPointer];
        nums[zeroIndexPointer] = tmp;
    }
}

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {1,0,1};

        Solution solution = new Solution();
        solution.moveZeroes(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
