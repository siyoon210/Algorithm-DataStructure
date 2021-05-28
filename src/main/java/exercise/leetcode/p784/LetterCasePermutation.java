package exercise.leetcode.p784;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    Set<String> letters;

    public List<String> letterCasePermutation(String S) {
        letters = new HashSet<>();
        findLetter(S, "", 0);

        return new ArrayList<>(letters);
    }

    private void findLetter(String S, String currStr, int index) {
        if (index >= S.length()) {
            letters.add(currStr);
            return;
        }

        final char c = S.charAt(index);
        if (c >= '0' && c <= '9') {
            currStr += c;
            findLetter(S, currStr, index + 1);
            return;
        }

        //소문자인 경우
        if (c >= 'a') {
            currStr += c;
        } else {
            currStr += (char)(c + ' ');
        }

        findLetter(S, currStr, index + 1);
        currStr = currStr.substring(0, currStr.length() - 1);

        //대문자인 경우
        if (c >= 'a') {
            currStr += (char)(c - ' ');
        } else {
            currStr += c;
        }

        findLetter(S, currStr, index + 1);
    }
}

public class LetterCasePermutation {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.letterCasePermutation("a1b2")).isEqualTo(Arrays.asList("a1b2", "a1B2", "A1b2", "A1B2"));
        assertThat(solution.letterCasePermutation("C")).isEqualTo(Arrays.asList("c", "C"));
    }
}
