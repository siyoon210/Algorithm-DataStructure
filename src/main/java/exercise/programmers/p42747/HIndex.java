package exercise.programmers.p42747;

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            answer = Math.max(answer, Math.min(citations[i], citations.length - i));
        }
        return answer;
    }
}

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
//        int[] citations = {22, 42};
//        int[] citations = {0, 0, 0, 0};

        Solution solution = new Solution();
        System.out.println(solution.solution(citations));
    }
}
