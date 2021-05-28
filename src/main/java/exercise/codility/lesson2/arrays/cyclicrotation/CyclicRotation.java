package exercise.codility.lesson2.arrays.cyclicrotation;

import java.util.LinkedList;

class Solution {
    public int[] solution(int[] A, int K) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i : A) {
            linkedList.add(i);
        }

        if (linkedList.size() > 0) {
            K %= linkedList.size();
        }


        for (int i = 0; i < K; i++) {
            Integer integer = linkedList.pollLast();
            linkedList.addFirst(integer);
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = linkedList.get(i);
        }

        return A;
    }
}

public class CyclicRotation {
    public static void main(String[] args) {
        int[] A = {};
        int K = 4;

        Solution solution = new Solution();
        int[] solution1 = solution.solution(A, K);

        for (int i : solution1) {
            System.out.print(i+"\t");
        }
    }
}
