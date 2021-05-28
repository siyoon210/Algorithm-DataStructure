package exercise.hackerrank.fibonaccimodified;

import java.math.BigDecimal;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    static String fibonacciModified(int t1, int t2, int n) {
        BigDecimal[] fibonacciDp = new BigDecimal[n + 1];
        fibonacciDp[1] = BigDecimal.valueOf(t1);
        fibonacciDp[2] = BigDecimal.valueOf(t2);

        for (int i = 3; i <= n; i++) {
            fibonacciDp[i] = fibonacciDp[i - 2].add(fibonacciDp[i - 1].multiply(fibonacciDp[i - 1]));
        }

        return fibonacciDp[n].toString();
    }
}

public class FibonacciModified {
    public static void main(String[] args) {
        assertThat(Solution.fibonacciModified(0, 1, 5)).isEqualTo("5");
        assertThat(Solution.fibonacciModified(0, 1, 6)).isEqualTo("27");
        assertThat(Solution.fibonacciModified(0, 1, 10)).isEqualTo("84266613096281243382112");

        out.println("fibonacciModified" + " success!");
    }
}
