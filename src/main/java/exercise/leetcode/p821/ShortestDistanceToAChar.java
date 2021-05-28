package exercise.leetcode.p821;

import java.util.Arrays;

class Solution {
    public int[] shortestToChar(String S, char C) {
        int strLength = S.length();
        int lastIdxOfprevC = -strLength;
        int[] answer = new int[strLength];
        for (int i = 0; i < strLength; i++) {
            if (S.charAt(i) == C) {
                lastIdxOfprevC = i;
            }
            answer[i] = i - lastIdxOfprevC;
        }

        lastIdxOfprevC = strLength * 2;
        for (int i = strLength - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                lastIdxOfprevC = i;
            }
            answer[i] = Math.min(answer[i], lastIdxOfprevC - i);
        }

        return answer;
    }
}

public class ShortestDistanceToAChar {
    public static void main(String[] args) {
        String S = "abaa";
        char C = 'b';


        Solution solution = new Solution();
        Arrays.stream(solution.shortestToChar(S, C)).forEach(System.out::println);
    }
}
