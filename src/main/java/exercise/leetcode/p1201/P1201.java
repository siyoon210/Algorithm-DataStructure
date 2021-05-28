package exercise.leetcode.p1201;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int[] uglyNumbers = new int[n];
        int index = 0;

        for (int i = min(a, b, c); index < n; i++) {
            if (i % a == 0 || i % b == 0 || i % c == 0) {
                uglyNumbers[index++] = i;
            }
        }

        for (int uglyNumber : uglyNumbers) {
            out.println(uglyNumber);
        }
        out.println();

        return uglyNumbers[n - 1];
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}

public class P1201 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.nthUglyNumber(3,2,3,5)).isEqualTo(4);
        assertThat(solution.nthUglyNumber(4,2,3,4)).isEqualTo(6);
        assertThat(solution.nthUglyNumber(5,2,11,13)).isEqualTo(10);
        assertThat(solution.nthUglyNumber(1000000000,2,217983653,336916467)).isEqualTo(1999999984);

        out.println("p1201" + " success!");
    }
}
