package codingTest.llst.gm2009.p1;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int solution(String S) {
        int consecutiveACount = 0;
        int aCount = 0;
        int nonACount = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'a') {
                aCount++;
                consecutiveACount++;
            } else {
                nonACount++;
                consecutiveACount = 0;
            }

            if (consecutiveACount >= 3) {
                return -1;
            }
        }

        return (nonACount + 1) * 2 - aCount;
    }
}
public class P1 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution("aabab")).isEqualTo(3);
        assertThat(solution.solution("dog")).isEqualTo(8);
        assertThat(solution.solution("aa")).isEqualTo(0);
        assertThat(solution.solution("baaaa")).isEqualTo(-1);

        out.println("p1" + " success!");
    }
}
