package exercise.programmers.p12919;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public String solution(String[] seoul) {
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                return "김서방은 " + i + "에 있다";
            }
        }
        return null;
    }
}

public class FindKim {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new String[]{"Jane", "Kim"})).isEqualTo("김서방은 1에 있다");
    }
}
