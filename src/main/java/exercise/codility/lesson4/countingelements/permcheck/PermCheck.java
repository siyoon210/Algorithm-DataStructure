package exercise.codility.lesson4.countingelements.permcheck;

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return 0;
            }
        }

        return 1;
    }
}

public class PermCheck {
    public static void main(String[] args) {
        int[] A = {4, 1, 3, 2};

        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }
}
