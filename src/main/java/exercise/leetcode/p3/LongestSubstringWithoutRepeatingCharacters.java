package exercise.leetcode.p3;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> subChars = new HashSet<>();
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (subChars.contains(s.charAt(i))) {
                maxLength = Math.max(subChars.size(), maxLength);
                subChars.clear();
            }

            subChars.add(s.charAt(i));
        }

        maxLength = Math.max(subChars.size(), maxLength);
        return maxLength;
    }
}

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
        assertThat(solution.lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
        assertThat(solution.lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
        assertThat(solution.lengthOfLongestSubstring(" ")).isEqualTo(1);
        assertThat(solution.lengthOfLongestSubstring("")).isEqualTo(0);
        assertThat(solution.lengthOfLongestSubstring("dvdf")).isEqualTo(3);
    }
}
