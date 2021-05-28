package exercise.programmers.p12932;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];
        int idx = 0;

        while (n > 0) {
            answer[idx++] = (int) (n % 10);
            n /= 10;
        }

        return answer;
    }
}

public class P12932 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.solution(12345)).isEqualTo(new int[]{5, 4, 3, 2, 1});
        assertThat(solution.solution(12045)).isEqualTo(new int[]{5, 4, 0, 2, 1});
        assertThat(solution.solution(100)).isEqualTo(new int[]{0, 0, 1});
        assertThat(solution.solution(10_000_000_000L)).isEqualTo(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1});
    }
}
