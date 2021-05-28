package codingTest.ln20.p2;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    String answerSheet;

    public int solution(String answer_sheet, String[] sheets) {
        this.answerSheet = answer_sheet;
        int answer = 0;

        for (int i = 0; i < sheets.length; i++) {
            for (int j = i; j < sheets.length; j++) {
                if (i == j) {
                    continue;
                }
                answer = Math.max(answer, calcCheatScore(sheets[i], sheets[j]));
            }
        }

        return answer;
    }

    private int calcCheatScore(String sheets1, String sheets2) {
        int totalSuspicious = 0;
        int longestConsecutiveSuspicious = 1;
        int currConsecutiveSuspicious = 1;
        boolean isConsecutive = false;
        for (int i = 0; i < sheets1.length(); i++) {
            if (isSuspiciousAnswer(sheets1, sheets2, i)) {
                totalSuspicious++;
                if (isConsecutive) {
                    currConsecutiveSuspicious++;
                    longestConsecutiveSuspicious = Math.max(longestConsecutiveSuspicious, currConsecutiveSuspicious);
                }
                isConsecutive = true;
                continue;
            }
            currConsecutiveSuspicious = 1;
            isConsecutive = false;
        }


        return totalSuspicious + (int) Math.pow(longestConsecutiveSuspicious, 2);
    }

    private boolean isSuspiciousAnswer(String sheets1, String sheets2, int i) {
        return (sheets1.charAt(i) == sheets2.charAt(i)) && sheets1.charAt(i) != answerSheet.charAt(i);
    }
}

public class P2 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution("4132315142", new String[]{"3241523133", "4121314445", "3243523133", "4433325251", "2412313253"})).isEqualTo(17);
        assertThat(solution.solution("53241", new String[]{"53241", "42133", "53241", "14354"})).isEqualTo(0);
        assertThat(solution.solution("24551", new String[]{"24553", "24553", "24553", "24553"})).isEqualTo(2);

        out.println("ln P2" + " success!");
    }
}
