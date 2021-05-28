package codingTest.wooa.wb2012.p4;

import java.util.Arrays;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        ;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
            while (i < m - 1 && B[i] < A[k])
                i += 1;
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }
}


public class P4 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new int[]{1, 3, 2, 1}, new int[]{4, 2, 5, 3, 2})).isEqualTo(2);
        assertThat(solution.solution(new int[]{2, 1}, new int[]{3, 3})).isEqualTo(-1);
        assertThat(solution.solution(new int[]{1, 50}, new int[]{0, 10, 20, 50})).isEqualTo(50);
        assertThat(solution.solution(new int[]{0, 10, 20, 50}, new int[]{1, 50})).isEqualTo(50);
        assertThat(solution.solution(new int[]{2}, new int[]{1})).isEqualTo(-1);
        assertThat(solution.solution(new int[]{0}, new int[]{0})).isEqualTo(0);
        assertThat(solution.solution(new int[]{0, 100_000}, new int[]{100_000})).isEqualTo(100_000);
        assertThat(solution.solution(new int[]{1, 2, 3}, new int[]{1, 3, 4})).isEqualTo(1);

        out.println("p4" + " success!");
    }
}