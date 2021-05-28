package exercise.leetcode.p1672;

import java.util.Arrays;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int[] account : accounts) {
            int wealth = Arrays.stream(account)
                    .sum();
            maxWealth = Math.max(maxWealth, wealth);
        }

        return maxWealth;
    }
}

public class P1672 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}})).isEqualTo(6);
        assertThat(solution.maximumWealth(new int[][]{{1, 5}, {3, 7}, {3, 5}})).isEqualTo(10);
        assertThat(solution.maximumWealth(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}})).isEqualTo(17);

        out.println("1672" + " success!");
    }
}
