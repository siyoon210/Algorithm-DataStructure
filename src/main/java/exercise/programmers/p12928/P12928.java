package exercise.programmers.p12928;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }

        return answer;
    }
}

public class P12928 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.solution(12)).isEqualTo(28);
        assertThat(solution.solution(5)).isEqualTo(6);
    }
}
