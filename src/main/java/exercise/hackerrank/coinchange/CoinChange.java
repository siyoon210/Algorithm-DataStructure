package exercise.hackerrank.coinchange;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public long getWays(int n, List<Long> c) {
        int[] combination = new int[n + 1];
        combination[0] = 1;
        Collections.sort(c);

        for (Long coin : c) {
            for (int amount = 1; amount < combination.length; amount++) {
                if (amount >= coin) {
                    combination[amount] += combination[(int) (amount - coin)];
                }
            }
        }
        Arrays.stream(combination)
                .sum();
        return combination[n];
    }
}

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.getWays(3, asList(8L, 3L, 1L, 2L))).isEqualTo(3);
        assertThat(solution.getWays(4, asList(1L, 2L, 3L))).isEqualTo(4);
        assertThat(solution.getWays(10, asList(2L, 5L, 3L, 6L))).isEqualTo(5);

        out.println("coin change" + " success!");
    }
}
