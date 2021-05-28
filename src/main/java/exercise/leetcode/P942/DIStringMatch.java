package exercise.leetcode.P942;

class Solution {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int lowest = 0, highest = N;
        int[] answer = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I')
                answer[i] = lowest++;
            else
                answer[i] = highest--;
        }

        answer[N] = lowest;
        return answer;
    }
}

public class DIStringMatch {
    public static void main(String[] args) {
        String S = "IDID";

        Solution solution = new Solution();
        for (int i : solution.diStringMatch(S)) {
            System.out.print(i + "\t");
        }
    }
}
