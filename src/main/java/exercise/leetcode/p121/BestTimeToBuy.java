package exercise.leetcode.p121;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

//121. Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }
}

public class BestTimeToBuy {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(5);
        assertThat(solution.maxProfit(new int[]{7, 6, 4, 3, 1})).isEqualTo(0);

        out.println("p121" + " success!");
    }
}
