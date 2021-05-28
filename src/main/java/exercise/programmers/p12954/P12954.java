package exercise.programmers.p12954;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public long[] solution(long x, int n) {
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = x * (i + 1);
        }

        return answer;
    }
}

public class P12954 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.solution(2, 5)).isEqualTo(new long[]{2, 4, 6, 8, 10});
        assertThat(solution.solution(4, 3)).isEqualTo(new long[]{4, 8, 12});
        assertThat(solution.solution(-4, 2)).isEqualTo(new long[]{-4, -8});
    }
}
