package exercise.codility.lesson3.tapeequilibrium;

class Solution {
    public int solution(int[] A) {
        int sumOfLeftSide = 0;
        int sumOfRightSide = 0;
        int minGap = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            sumOfRightSide += A[i];
        }

        for (int i = 0; i < A.length - 1; i++) {
            int indexValue = A[i];
            sumOfLeftSide += indexValue;
            sumOfRightSide -= indexValue;
            minGap = Math.min(minGap, Math.abs((sumOfLeftSide - sumOfRightSide)));
        }

        return minGap;
    }
}

public class TapeEquilibrium {
    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4, 3};

        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }
}
