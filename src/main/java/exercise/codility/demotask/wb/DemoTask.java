package exercise.codility.demotask.wb;

import java.util.Arrays;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);

        if (A[A.length - 1] <= 0) {
            return 1;
        }

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] <= 0) {
                continue;
            }

            if (A[i] == A[i + 1]) {
                continue;
            }

            if (A[i] + 1 == A[i + 1]) {
                continue;
            }

            return A[i] + 1;
        }

        return A[A.length - 1] + 1;
    }
}


public class DemoTask {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new int[]{1, 3, 6, 4, 1, 2})).isEqualTo(5);
        assertThat(solution.solution(new int[]{1, 2, 3})).isEqualTo(4);
        assertThat(solution.solution(new int[]{-1, -3})).isEqualTo(1);

        out.println("demo" + " success!");
    }
}
