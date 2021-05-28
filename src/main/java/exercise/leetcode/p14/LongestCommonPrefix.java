package exercise.leetcode.p14;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int charPointer = 0;
        char baseChar = Character.MIN_VALUE;

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() <= charPointer) {
                break;
            }

            if (i == 0) {
                baseChar = strs[i].charAt(charPointer);
            }

            if (baseChar != strs[i].charAt(charPointer)) {
                break;
            }

            if (i == strs.length - 1) {
                sb.append(baseChar);
                charPointer++;
                i = -1;
            }
        }

        return sb.toString();
    }
}

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog","racecar","car"};
        String[] strs3 = {""};
        String[] strs4 = {"a"};
        String[] strs5 = {"aaa","aa","aaa"};

        assertThat(solution.longestCommonPrefix(strs1)).isEqualTo("fl");
        assertThat(solution.longestCommonPrefix(strs2)).isEqualTo("");
        assertThat(solution.longestCommonPrefix(strs3)).isEqualTo("");
        assertThat(solution.longestCommonPrefix(strs4)).isEqualTo("a");
        assertThat(solution.longestCommonPrefix(strs5)).isEqualTo("aa");
        System.out.println("END");
    }
}
