package exercise.programmers.p12948;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public String solution(String phoneNum) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < phoneNum.length(); i++) {
            if (i > phoneNum.length() - 5) {
                sb.append(phoneNum.charAt(i));
                continue;
            }

            sb.append("*");
        }

        return sb.toString();
    }
}

public class HideCellPhoneNum {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution("01033334444")).isEqualTo("*******4444");
        assertThat(solution.solution("027778888")).isEqualTo("*****8888");
    }
}
