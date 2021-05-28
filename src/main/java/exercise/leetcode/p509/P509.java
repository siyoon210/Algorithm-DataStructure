package exercise.leetcode.p509;

import java.util.Arrays;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    private final int[] fibonacciNums;

    public Solution() {
        fibonacciNums = new int[31];
        Arrays.fill(fibonacciNums, -1);
        fibonacciNums[0] = 0;
        fibonacciNums[1] = 1;
    }

    public int fib(int N) {
        if (fibonacciNums[N] != -1) {
            return fibonacciNums[N];
        }

        fibonacciNums[N] = fib(N - 1) + fib(N - 2);
        return fibonacciNums[N];
    }
}

public class P509 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.fib(2)).isEqualTo(1);
        assertThat(solution.fib(3)).isEqualTo(2);
        assertThat(solution.fib(4)).isEqualTo(3);

        out.println("p509" + " success!");
    }
}
