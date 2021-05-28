package exercise.codility.lesson4.countingelements.frogriverone;

import java.util.HashSet;
import java.util.Set;

//For example, for the input (2, [2, 2, 2, 2, 2]) the solution returned a wrong answer (got 0 expected -1).
class Solution {
    public int solution(int X, int[] A) {
        boolean isPresentGoal = false;
        Set<Integer> positions= new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] < X) {
                positions.add(A[i]);
            }
            if (A[i] == X) {
                isPresentGoal = true;
            }
            if (isPresentGoal && positions.size() == X - 1) {
                return i;
            }
        }

        return -1;
    }
}

public class FrogRiverOne {
    public static void main(String[] args) {
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        int X = 5;
//        int[] A = {2, 2, 2, 2, 2};
//        int X = 2;

        Solution solution = new Solution();
        System.out.println(solution.solution(X, A));
    }
}
