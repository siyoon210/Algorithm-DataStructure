package exercise.codility.lesson6.triangle;

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        int triangularCount = 0;

        for (int i = 0; i < A.length - 2; i++) {
            if (A[i + 1] > A[i + 2] - A[i]) {
                return 1;
            }
        }

        return 0;
    }
}

public class Triangle {
    public static void main(String[] args) {
//        int[] A = {10, 2, 5, 1, 8, 20};
        int[] A = {1, 1, 1, 1, 5, 5, 5};


        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }
}
