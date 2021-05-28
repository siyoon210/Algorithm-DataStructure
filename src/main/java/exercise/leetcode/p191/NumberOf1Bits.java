package exercise.leetcode.p191;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }

        return count;
    }
}

public class NumberOf1Bits {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 00000000000000000000000000001011;
        int n2 = 00000000000000000000000010000000;
//        int n3 = 11111111111111111111111111111101;

        assertThat(solution.hammingWeight(n1)).isEqualTo(3);
        assertThat(solution.hammingWeight(n2)).isEqualTo(1);
    }
}
