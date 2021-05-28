package exercise.leetcode.p279;

import java.util.Arrays;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return f(n, dp);
    }

    private int f(int n, int[] dp) {
        if (dp[n] != Integer.MAX_VALUE) {
            return dp[n];
        }

        if (isPerfectSquare(n)) {
            dp[n] = 1;
            return dp[n];
        }

        for (int i = 1; i * i < n; i++) {
            dp[n] = Math.min(dp[n], f(n - (i * i), dp) + 1);
        }

        return dp[n];
    }

    private boolean isPerfectSquare(int n) {
        double sq = Math.sqrt(n);
        return (sq - Math.floor(sq)) == 0;
    }
}

/**
 * 1) 1, 4, 9, 16, 25 ... 이러한 숫자는 이미 완전제곱 (perfect square) 형태다.
 * 2) n 보다 작은 완전제곱 수를 이용하여서 경우의수를 모두 구한다.
 * 예를들어, n이 12이라면 1, 4, 9 3가지 경우의수를 먼저 구할 수 있다.
 * <p>
 * 정수n을 합으로 만드는 가장 적은 완전제곱의 조합의 갯수를 찾는 함수를 f(n)이라고 할때,
 * n이 12인 경우 1,4,9 3가지의 조합이 있다.
 * 만약 1을 선택한 경우 f(1) + f(12-1) = 1 + f(11)
 * 만약 4를 선택한 경우 f(4) + f(12-4) = 1 + f(8)
 * 만약 9를 선택한 경우 f(9) + f(12-9) = 1 + f(3)
 * 의 형태로 나타낼 수있다.
 * 이제 괄호 안에 숫자들을 이용하여 재귀적으로 찾아낸다.
 */

public class P279 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.numSquares(2)).isEqualTo(2);
        assertThat(solution.numSquares(3)).isEqualTo(3);
        assertThat(solution.numSquares(4)).isEqualTo(1);
        assertThat(solution.numSquares(5)).isEqualTo(2);
        assertThat(solution.numSquares(6)).isEqualTo(3);
        assertThat(solution.numSquares(7)).isEqualTo(4);
        assertThat(solution.numSquares(8)).isEqualTo(2);
        assertThat(solution.numSquares(12)).isEqualTo(3);
        assertThat(solution.numSquares(13)).isEqualTo(2);

        out.println("p279" + " success!");
    }
}
