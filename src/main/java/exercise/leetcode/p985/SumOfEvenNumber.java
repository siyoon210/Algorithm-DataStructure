package exercise.leetcode.p985;

class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] answer = new int[queries.length];
        int sumOfEvenNumbers = initSumOfEvenNumber(A);

        for (int i = 0; i < queries.length; i++) {
            int numBeforeQuery = A[queries[i][1]];
            int numAfterQuery = A[queries[i][1]] += queries[i][0];

            //경우1 원래 홀수였던것이 홀수가 된 경우 - 무시
            //경우2 원래 홀수였던것이 짝수가 된 경우 - 새로이 합산
            //경우3 원래 짝수였던것이 홀수가 된 경우 - 원래 짝수를 뺀다.
            //경우4 원래 짝수였던것이 짝수가 된 경우 - 증가된 수만큼만 합산
            if (!isEvenNumber(numBeforeQuery) && isEvenNumber(numAfterQuery)) {
                sumOfEvenNumbers += numAfterQuery;
            } else if (isEvenNumber(numBeforeQuery) && !isEvenNumber(numAfterQuery)) {
                sumOfEvenNumbers -= numBeforeQuery;
            } else if (isEvenNumber(numBeforeQuery) && isEvenNumber(numAfterQuery)) {
                sumOfEvenNumbers += numAfterQuery - numBeforeQuery;
            }

            answer[i] = sumOfEvenNumbers;
        }

        return answer;
    }

    private int initSumOfEvenNumber(int[] A) {
        int sumOfEvenNumbers = 0;
        for (int i : A) {
            if (isEvenNumber(i)) sumOfEvenNumbers += i;
        }
        return sumOfEvenNumbers;
    }

    private boolean isEvenNumber(int i) {
        return i % 2 == 0;
    }
}

public class SumOfEvenNumber {
    public static void main(String[] args) {
        int[] A = {3, 2};
        int[][] queries = {{4, 0}, {3, 0}};

        Solution solution = new Solution();
        for (int i : solution.sumEvenAfterQueries(A, queries)) {
            System.out.println(i);
        }
    }
}
