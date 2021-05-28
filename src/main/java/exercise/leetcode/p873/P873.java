package exercise.leetcode.p873;

import java.util.HashSet;
import java.util.Set;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int N = A.length;
        Set<Integer> S = new HashSet();
        for (int x: A) S.add(x);

        int ans = 0;
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j) {
                /* With the starting pair (A[i], A[j]),
                 * y represents the future expected value in
                 * the fibonacci subsequence, and x represents
                 * the most current value found. */
                int x = A[j], y = A[i] + A[j];
                int length = 2;
                while (S.contains(y)) {
                    // x, y -> y, x+y
                    int tmp = y;
                    y += x;
                    x = tmp;
                    ans = Math.max(ans, ++length);
                }
            }

        return ans >= 3 ? ans : 0;
    }
}

public class P873 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8})).isEqualTo(5);
        assertThat(solution.lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18})).isEqualTo(3);

        out.println("p873" + " success!");
    }
}
