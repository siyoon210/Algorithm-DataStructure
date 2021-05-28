package exercise.codility.lesson6.distinct;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] A) {
        Set<Integer> nums = new HashSet<>();

        for (int i : A) {
            nums.add(i);
        }

        return nums.size();
    }
}

public class Distinct {
    public static void main(String[] args) {
        int[] A = {2, 1, 1, 2, 3, 1};

        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }
}
