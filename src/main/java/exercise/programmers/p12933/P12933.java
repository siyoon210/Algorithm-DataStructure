package exercise.programmers.p12933;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public long solution(long n) {
        String[] split = String.valueOf(n).split("");
        Arrays.sort(split, Collections.reverseOrder());
        return Long.parseLong(String.join("", split));
    }
}

public class P12933 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.solution(218371)).isEqualTo(873211);
        assertThat(solution.solution(118372)).isEqualTo(873211);
    }
}
