package exercise.programmers.p12982;

import java.util.Arrays;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int count = 0;

        for (int value : d) {
            budget -= value;
            if (budget >= 0) {
                count++;
            }
        }

        return count;
    }
}

public class P12982 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new int[]{1, 3, 2, 5, 4}, 9)).isEqualTo(3);
        assertThat(solution.solution(new int[]{2, 2, 3, 3}, 10)).isEqualTo(4);

        out.println("p12982" + " success!");
    }
}
