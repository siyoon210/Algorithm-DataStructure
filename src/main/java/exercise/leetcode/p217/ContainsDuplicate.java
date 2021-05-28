package exercise.leetcode.p217;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();

        for (int num : nums) {
            if (!integerSet.add(num)) {
                return true;
            }
        }

        return false;
    }
}

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(nums));
    }
}
