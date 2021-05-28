package exercise.leetcode.p264;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    private static class UglyNum {
        private final int originFactor;
        private int value;
        private int index = 0;

        public UglyNum(int originFactor) {
            this.originFactor = originFactor;
            this.value = originFactor;
        }

        private void stepOver(int[] uglyNumbers, int uglyNum) {
            if (uglyNum == this.value) {
                this.index++;
                this.value = this.originFactor * uglyNumbers[index];
            }
        }
    }

    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;

        UglyNum origin2 = new UglyNum(2);
        UglyNum origin3 = new UglyNum(3);
        UglyNum origin5 = new UglyNum(5);

        for (int i = 1; i < n; i++) {
            uglyNumbers[i] = minValue(origin2, origin3, origin5);
            origin2.stepOver(uglyNumbers, uglyNumbers[i]);
            origin3.stepOver(uglyNumbers, uglyNumbers[i]);
            origin5.stepOver(uglyNumbers, uglyNumbers[i]);
        }

        return uglyNumbers[n - 1];
    }

    private int minValue(UglyNum origin2, UglyNum origin3, UglyNum origin5) {
        return Math.min(Math.min(origin2.value, origin3.value), origin5.value);
    }
}

public class P264 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.nthUglyNumber(10)).isEqualTo(12);
        assertThat(solution.nthUglyNumber(1)).isEqualTo(1);
        assertThat(solution.nthUglyNumber(4)).isEqualTo(4);
        assertThat(solution.nthUglyNumber(5)).isEqualTo(5);
        assertThat(solution.nthUglyNumber(6)).isEqualTo(6);
        assertThat(solution.nthUglyNumber(7)).isEqualTo(8);
        assertThat(solution.nthUglyNumber(8)).isEqualTo(9);
        assertThat(solution.nthUglyNumber(9)).isEqualTo(10);

        out.println("p264" + " success!");
    }
}
