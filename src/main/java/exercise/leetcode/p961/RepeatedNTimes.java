package exercise.leetcode.p961;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> integerSet = new HashSet<>();

        for (int i : A) {
            if (!integerSet.add(i)) {
                return i;
            }
        }

        return 0;
    }
}

public class RepeatedNTimes {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 3,};

        Solution solution = new Solution();
        System.out.println(solution.repeatedNTimes(A));
    }
}
