package exercise.leetcode.p1309;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public String freqAlphabets(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; ) {
            if (s.charAt(i) == '#') {
                String substring = s.substring(i - 2, i);
                stringBuilder.insert(0, (char)(Integer.parseInt(substring) + 96));
                i -= 3;
            } else {
                stringBuilder.insert(0, (char)(s.charAt(i) + 48));
                i--;
            }
        }

        return stringBuilder.toString();
    }
}

public class P1309 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.freqAlphabets("10#11#12")).isEqualTo("jkab");
        assertThat(solution.freqAlphabets("1326#")).isEqualTo("acz");
        assertThat(solution.freqAlphabets("25#")).isEqualTo("y");
        assertThat(solution.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#")).isEqualTo("abcdefghijklmnopqrstuvwxyz");
    }
}
