package exercise.leetcode.p12;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    static class Roman {
        String str;
        int value;

        public Roman(final String str, final int value) {
            this.str = str;
            this.value = value;
        }
    }

    public String intToRoman(int num) {
        List<Roman> romen = new ArrayList<>(13);
        romen.add(new Roman("M", 1000));
        romen.add(new Roman("CM", 900));
        romen.add(new Roman("D", 500));
        romen.add(new Roman("CD", 400));
        romen.add(new Roman("C", 100));
        romen.add(new Roman("XC", 90));
        romen.add(new Roman("L", 50));
        romen.add(new Roman("XL", 40));
        romen.add(new Roman("X", 10));
        romen.add(new Roman("IX", 9));
        romen.add(new Roman("V", 5));
        romen.add(new Roman("IV", 4));
        romen.add(new Roman("I", 1));

        StringBuilder sb = new StringBuilder();

        for (final Roman roman : romen) {
            final int i = num / roman.value;
            num = num % roman.value;
            for (int j = 0; j < i; j++) {
                sb.append(roman.str);
            }
        }

        return sb.toString();
    }
}

public class IntegerToRoman {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.intToRoman(3)).isEqualTo("III");
        assertThat(solution.intToRoman(4)).isEqualTo("IV");
        assertThat(solution.intToRoman(9)).isEqualTo("IX");
        assertThat(solution.intToRoman(58)).isEqualTo("LVIII");
        assertThat(solution.intToRoman(1994)).isEqualTo("MCMXCIV");
        System.out.println("끝!");
    }
}
