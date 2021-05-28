package exercise.programmers.p12947;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public boolean solution(int x) {
        int sum = Arrays.stream(String.valueOf(x).split(""))
                .mapToInt(Integer::valueOf)
                .sum();
        return x % sum == 0;
    }
}

public class P12947 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.solution(10)).isEqualTo(true);
        assertThat(solution.solution(12)).isEqualTo(true);
        assertThat(solution.solution(11)).isEqualTo(false);
        assertThat(solution.solution(13)).isEqualTo(false);
    }
}
