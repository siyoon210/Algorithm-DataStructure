package exercise.programmers.p12918;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public boolean solution(String s) {
        final int length = s.length();
        if (length != 4 && length != 6) {
            return false;
        }

        final char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar < '0' || aChar > '9') {
                return false;
            }
        }

        return true;
    }
}

public class HandlerStrBasic {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution("a234")).isEqualTo(false);
        assertThat(solution.solution("1234")).isEqualTo(true);
    }
}
