package exercise.leetcode.p392;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int pointerS = 0;

        if (s.isEmpty()) {
            return true;
        }

        for (int pointerT = 0; pointerT < t.length(); pointerT++) {
            if (s.charAt(pointerS) == t.charAt(pointerT)) {
                pointerS++;
            }

            if (pointerS >= s.length()) {
                return true;
            }
        }

        return false;
    }
}

public class P392 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.isSubsequence("abc", "ahbgdc")).isEqualTo(true);
        assertThat(solution.isSubsequence("axc", "ahbgdc")).isEqualTo(false);
        assertThat(solution.isSubsequence("ace", "abcde")).isEqualTo(true);
        assertThat(solution.isSubsequence("aec", "abcde")).isEqualTo(false);
        assertThat(solution.isSubsequence("", "ahbgdc")).isEqualTo(true);

        out.println("p392" + " success!");
    }
}
