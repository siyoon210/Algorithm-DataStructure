package exercise.leetcode.p1347;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int minSteps(String s, String t) {
        int step = 0;

        int[] numOfCharsS = new int[26];
        int[] numOfCharsT = new int[26];

        for (int i = 0; i < s.length(); i++) {
            numOfCharsS[s.charAt(i) - 'a']++;
            numOfCharsT[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < numOfCharsS.length; i++) {
            if (numOfCharsS[i] > numOfCharsT[i]) {
                step += numOfCharsS[i] - numOfCharsT[i];
            }
        }

        return step;
    }
}

public class P1347 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.minSteps("bab", "aba")).isEqualTo(1);
        assertThat(solution.minSteps("leetcode", "practice")).isEqualTo(5);
    }
}
