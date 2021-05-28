package exercise.codility.lesson5.prefixsums.countdiv;

//For example, for the input [0, 0, 11] the solution returned a wrong answer (got 0 expected 1).
//For example, for the input [0, 14, 2] the solution returned a wrong answer (got 1 expected 8).
class Solution {
    public int solution(int A, int B, int K) {
        Integer minIntDivigible = null;
        int answer = 0;

        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                minIntDivigible = i;
                answer++;
                break;
            }
        }

        if (minIntDivigible != null) {
            answer += (B - minIntDivigible) / K;
        }

        return answer;
    }
}

public class CountDiv {
    public static void main(String[] args) {
        int A = 0;
        int B = 14;
        int K = 2;

        Solution solution = new Solution();
        System.out.println(solution.solution(A, B, K));
    }
}
