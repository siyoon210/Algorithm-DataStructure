package exercise.programmers.p12934;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        return sqrt == (int) sqrt ? (long) Math.pow((int) sqrt + 1, 2) : -1;
    }
}

public class P12934 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.solution(121)).isEqualTo(144);
        assertThat(solution.solution(3)).isEqualTo(-1);
    }
}
