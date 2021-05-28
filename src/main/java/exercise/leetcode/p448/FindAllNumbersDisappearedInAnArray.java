package exercise.leetcode.p448;

import java.util.ArrayList;
import java.util.List;

//공간 복잡도가 O(n)이 넘지 않는 방법
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/92956/Java-accepted-simple-solution
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        for (final int num : nums) {
            int i = Math.abs(num) - 1;
            if (nums[i] > 0) {
                nums[i] = -nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                answer.add(i + 1);
            }
        }

        return answer;
    }
}

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        Solution solution = new Solution();
        solution.findDisappearedNumbers(nums).forEach(System.out::println);
    }
}
