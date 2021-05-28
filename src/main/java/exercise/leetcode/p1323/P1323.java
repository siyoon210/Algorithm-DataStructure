package exercise.leetcode.p1323;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int maximum69Number (int num) {
        final char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
                break;
            }
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}

public class P1323 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        assertThat(solution.maximum69Number(9669)).isEqualTo(9969);
        assertThat(solution.maximum69Number(9996)).isEqualTo(9999);

        out.println("p1323" + " success!");
    }
}
