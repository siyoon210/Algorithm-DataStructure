package exercise.leetcode.p977;

import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }

        Arrays.sort(A);
        return A;
    }
}

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] A = {-4, -1, 0, 3, 10};

        Solution solution = new Solution();
        for (int i : solution.sortedSquares(A)) {
            System.out.print(i+", ");
        }
    }
}
