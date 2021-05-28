package exercise.programmers.p12931;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }
}

public class SumPositionalNum {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(123)).isEqualTo(6);
        assertThat(solution.solution(987)).isEqualTo(24);
    }
}
