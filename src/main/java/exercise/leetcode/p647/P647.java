package exercise.leetcode.p647;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 시간복잡도 O(nm) 최악의경우 O(n^2)
 * 시간복잡도가 크게 나아지지는 않지만 String을 다루지 않기때문에 속도가 빨라짐
 */
class Solution2 {
    public int countSubstrings(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            answer += getCountOfPalindrome(s, i, i);
            answer += getCountOfPalindrome(s, i, i + 1);
        }

        return answer;
    }

    private int getCountOfPalindrome(String s, int i, int j) {
        int count = 0;

        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
                count++;
                continue;
            }
            break;
        }

        return count;
    }
}

public class P647 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        assertThat(solution.countSubstrings("abc")).isEqualTo(3);
        assertThat(solution.countSubstrings("aaa")).isEqualTo(6);

        out.println("p647" + " success!");
    }
}
