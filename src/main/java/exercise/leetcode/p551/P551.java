package exercise.leetcode.p551;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public boolean checkRecord(String s) {
        boolean containsA = false;
        int continuousL = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                continuousL++;

                if (continuousL > 2) {
                    return false;
                }

                continue;
            }
            continuousL = 0;

            if (s.charAt(i) == 'A') {
                if (containsA) {
                    return false;
                }

                containsA = true;
            }
        }

        return true;
    }
}

public class P551 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        assertThat(solution.checkRecord("PPALLP")).isEqualTo(true);
        assertThat(solution.checkRecord("PPALLL")).isEqualTo(false);

        out.println("P1" + " success!");
    }
}
