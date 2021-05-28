package exercise.leetcode.p1137;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    private final Integer[] tribonacciNums = new Integer[38];

    public Solution() {
        tribonacciNums[0] = 0;
        tribonacciNums[1] = 1;
        tribonacciNums[2] = 1;
    }

    public int tribonacci(int n) {
        if (n < 3) {
            return tribonacciNums[n];
        }

        if (tribonacciNums[n] != null) {
            return tribonacciNums[n];
        }

        tribonacciNums[n] = tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
        return tribonacciNums[n];
    }
}

public class P1137 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        assertThat(solution.tribonacci(4)).isEqualTo(4);
        assertThat(solution.tribonacci(25)).isEqualTo(1389537);

        out.println("p1137" + " success!");
    }
}
