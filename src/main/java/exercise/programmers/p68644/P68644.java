package exercise.programmers.p68644;

import java.util.TreeSet;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> sums = new TreeSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sums.add(numbers[i] + numbers[j]);
            }
        }

        return sums.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

public class P68644 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new int[]{2, 1, 3, 4, 1})).isEqualTo(new int[]{2, 3, 4, 5, 6, 7});

        out.println("p68644" + " success!");
    }
}
