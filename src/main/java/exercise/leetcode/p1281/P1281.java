package exercise.leetcode.p1281;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;

        while (n > 0) {
            int i = n % 10;
            product *= i;
            sum += i;
            n /= 10;
        }

        return product - sum;
    }
}

public class P1281 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.subtractProductAndSum(234)).isEqualTo(15);
        assertThat(solution.subtractProductAndSum(4421)).isEqualTo(21);
    }
}
