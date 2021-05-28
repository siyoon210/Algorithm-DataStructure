package exercise.codility.lesson5.prefixsums.genomicrangequery;

// For example, for the input ('A', [0], [0]) the solution returned a wrong answer (got [4] expected [1]).
// For example, for the input ('AC', [0, 0, 1], [0, 1, 1]) the solution returned a wrong answer (got [1, 2, 2] expected [1, 1, 2]).
class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        int[] A = new int[S.length() + 1];
        int[] C = new int[S.length() + 1];
        int[] G = new int[S.length() + 1];

        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'A':
                    A[i + 1]++;
                    break;
                case 'C':
                    C[i + 1]++;
                    break;
                case 'G':
                    G[i + 1]++;
                    break;
                default:
                    break;
            }

            A[i + 1] += A[i];
            C[i + 1] += C[i];
            G[i + 1] += G[i];
        }

        int[] answer = new int[P.length];

        for (int i = 0; i < answer.length; i++) {
            int startIndex = P[i];
            int endIndex = Q[i];

            if (startIndex == endIndex) {
                char c = S.charAt(startIndex);

                switch (c) {
                    case 'A':
                        answer[i] = 1;
                        break;
                    case 'C':
                        answer[i] = 2;
                        break;
                    case 'G':
                        answer[i] = 3;
                        break;
                    case 'T':
                        answer[i] = 4;
                        break;
                }
            } else if (A[startIndex] != A[endIndex + 1]) {
                answer[i] = 1;
            } else if (C[startIndex] != C[endIndex + 1]) {
                answer[i] = 2;
            } else if (G[startIndex] != G[endIndex + 1]) {
                answer[i] = 3;
            } else {
                answer[i] = 4;
            }
        }

        return answer;
    }
}

public class GenomicRangeQuery {
    public static void main(String[] args) {
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
//        String S = "AC";
//        int[] P = {0, 0, 1};
//        int[] Q = {0, 1, 1};

        Solution solution = new Solution();
        int[] solution1 = solution.solution(S, P, Q);
        for (int i : solution1) {
            System.out.print(i + "\t");
        }
    }
}
