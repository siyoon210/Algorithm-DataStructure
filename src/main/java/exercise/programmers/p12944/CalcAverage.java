package exercise.programmers.p12944;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public double solution(int[] arr) {
        return Arrays.stream(arr).average().orElse(0);
    }
}

public class CalcAverage {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new int[]{1, 2, 3, 4})).isEqualTo(2.5);
        assertThat(solution.solution(new int[]{5, 5})).isEqualTo(5);
    }
}
