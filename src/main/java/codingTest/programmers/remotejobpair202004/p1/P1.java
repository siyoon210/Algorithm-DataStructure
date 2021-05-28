package codingTest.programmers.remotejobpair202004.p1;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int solution(String p, String s) {
        int answer = 0;
        for (int i = 0; i < p.length(); i++) {
            answer += minMovement(p.charAt(i) - '0', s.charAt(i) - '0');
        }
        return answer;
    }

    private int minMovement(int curr, int target) {
        return Math.min(forwardDirection(curr, target), reverseDirection(curr, target));
    }

    private int forwardDirection(int curr, int target) {
        int i = 0;
        while (curr != target) {
            curr++;
            if (curr >= 10) {
                curr = 0;
            }
            i++;
        }

        return i;
    }

    private int reverseDirection(int curr, int target) {
        int i = 0;
        while (curr != target) {
            curr--;
            if (curr < 0) {
                curr = 9;
            }
            i++;
        }

        return i;
    }
}
public class P1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        assertThat(solution.solution("82195", "64723")).isEqualTo(13);
        assertThat(solution.solution("00000000000000000000", "91919191919191919191")).isEqualTo(20);

        out.println("prog P1" + " success!");
    }
}
