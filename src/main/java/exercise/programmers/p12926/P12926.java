package exercise.programmers.p12926;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public String solution(String s, int n) {
        char[] chars = s.toCharArray();
        char[] answer = new char[chars.length];

        if (n > 26) {
            n = n % 26;
        }

        for (int i = 0; i < chars.length; i++) {
            if (isLowerCaseAlphabet(chars[i])) {
                if (!isLowerCaseAlphabet((char) (chars[i] + n))) {
                    answer[i] = (char) (chars[i] + n - 26);
                    continue;
                }
                answer[i] = (char) (chars[i] + n);
                continue;
            }

            if (isUpperCaseAlphabet(chars[i])) {
                if (!isUpperCaseAlphabet((char) (chars[i] + n))) {
                    answer[i] = (char) (chars[i] + n - 26);
                    continue;
                }
                answer[i] = (char) (chars[i] + n);
                continue;
            }

            answer[i] = chars[i];
        }

        return String.valueOf(answer);
    }

    private boolean isUpperCaseAlphabet(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private boolean isLowerCaseAlphabet(char c) {
        return c >= 'a' && c <= 'z';
    }
}

public class P12926 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.solution("AB", 1)).isEqualTo("BC");
        assertThat(solution.solution("z", 1)).isEqualTo("a");
        assertThat(solution.solution("a B z", 4)).isEqualTo("e F d");
    }
}
