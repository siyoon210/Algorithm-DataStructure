package exercise.codility.lesson3.permmissingelem;

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return A.length + 1;
    }
}

public class PermMissingElem {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 5};

        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }
}
