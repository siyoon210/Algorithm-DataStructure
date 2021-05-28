package exercise.codility.lesson4.countingelements.missinginteger;

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if (Arrays.binarySearch(A, i + 1) < 0) {
                return i + 1;
            }
        }

        return A.length + 1;
    }
}

public class MissingInteger {
    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};

        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }
}
