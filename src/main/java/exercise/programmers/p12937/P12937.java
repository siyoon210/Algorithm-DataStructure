package exercise.programmers.p12937;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }
}

public class P12937 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.solution(3)).isEqualTo("Odd");
        assertThat(solution.solution(4)).isEqualTo("Even");
    }
}
