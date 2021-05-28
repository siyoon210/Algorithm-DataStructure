package exercise.programmers.p12930;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public String solution(String s) {
        final char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int index = 0;

        for (final char c : chars) {
            if (c == ' ') {
                index = 0;
                sb.append(c);
                continue;
            }

            if (index % 2 == 0) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }

            index++;
        }

        return sb.toString();
    }
}

public class MakeStrangeString {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution("try hello world")).isEqualTo("TrY HeLlO WoRlD");
    }
}
