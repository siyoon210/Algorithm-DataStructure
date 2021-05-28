package exercise.programmers.p12935;

import java.util.Arrays;
import java.util.OptionalInt;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int[] solution(int[] arr) {
        final OptionalInt min = Arrays.stream(arr).min();

        if (!min.isPresent()) {
            return new int[]{-1};
        }

        final int[] ints = Arrays.stream(arr)
                .filter(i -> i != min.getAsInt())
                .toArray();

        if (ints.length == 0) {
            return new int[]{-1};
        }

        return ints;
    }
}

public class P12935 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.solution(new int[]{4, 3, 2, 1})).isEqualTo(new int[]{4, 3, 2});
        assertThat(solution.solution(new int[]{10})).isEqualTo(new int[]{-1});
    }
}
