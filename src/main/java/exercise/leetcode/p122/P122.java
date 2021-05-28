package exercise.leetcode.p122;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}

public class P122 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(7);
        assertThat(solution.maxProfit(new int[]{1, 2, 3, 4, 5})).isEqualTo(4);
        assertThat(solution.maxProfit(new int[]{7, 6, 4, 3, 1})).isEqualTo(0);

        out.println("p122" + " success!");
    }
}
