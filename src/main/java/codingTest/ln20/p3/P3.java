package codingTest.ln20.p3;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int solution(String road, int n) {
        int answer = -1;
        final String[] split = road.split("0");
        for (String s : split) {
            out.println(s);
        }
        return answer;
    }
}

public class P3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        assertThat(solution.solution("111011110011111011111100011111", 3)).isEqualTo(18);
        assertThat(solution.solution("001100", 5)).isEqualTo(6);

        out.println("ln p3" + " success!");
    }
}
