package exercise.leetcode.p5;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            final String str1 = extend(s, i, i);
            if (str1.length() > longest.length()) {
                longest = str1;
            }
            final String str2 = extend(s, i, i + 1);
            if (str2.length() > longest.length()) {
                longest = str2;
            }
        }
        return longest;
    }

    private String extend(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }

        return s.substring(i + 1, j);
    }
}

public class P5 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.longestPalindrome("babad")).isEqualTo("bab");
        assertThat(solution.longestPalindrome("cbbd")).isEqualTo("bb");
        assertThat(solution.longestPalindrome("a")).isEqualTo("a");
        assertThat(solution.longestPalindrome("")).isEqualTo("");
        assertThat(solution.longestPalindrome("bb")).isEqualTo("bb");

        out.println("leet p5" + " success!");
    }
}
