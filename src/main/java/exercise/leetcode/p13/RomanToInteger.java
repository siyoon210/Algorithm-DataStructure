package exercise.leetcode.p13;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int romanToInt(String s) {
        int answer = 0;
        int pointer = 0;

        while (pointer < s.length()) {
            if (s.charAt(pointer) == 'I') {
                if (pointer < s.length() - 1) {
                    if (s.charAt(pointer + 1) == 'V') {
                        answer += 4;
                        pointer += 2;
                        continue;
                    } else if (s.charAt(pointer + 1) == 'X') {
                        answer += 9;
                        pointer += 2;
                        continue;
                    }
                }
                answer += 1;
                pointer++;
            } else if (s.charAt(pointer) == 'V') {
                answer += 5;
                pointer++;
            } else if (s.charAt(pointer) == 'X') {
                if (pointer < s.length() - 1) {
                    if (s.charAt(pointer + 1) == 'L') {
                        answer += 40;
                        pointer += 2;
                        continue;
                    } else if (s.charAt(pointer + 1) == 'C') {
                        answer += 90;
                        pointer += 2;
                        continue;
                    }
                }
                answer += 10;
                pointer++;
            } else if (s.charAt(pointer) == 'L') {
                answer += 50;
                pointer++;
            } else if (s.charAt(pointer) == 'C') {
                if (pointer < s.length() - 1) {
                    if (s.charAt(pointer + 1) == 'D') {
                        answer += 400;
                        pointer += 2;
                        continue;
                    } else if (s.charAt(pointer + 1) == 'M') {
                        answer += 900;
                        pointer += 2;
                        continue;
                    }
                }
                answer += 100;
                pointer++;
            } else if (s.charAt(pointer) == 'D') {
                answer += 500;
                pointer++;
            } else if (s.charAt(pointer) == 'M') {
                answer += 1000;
                pointer++;
            }
        }

        return answer;
    }
}

public class RomanToInteger {
    public static void main(String[] args) {
        String s1 = "III";
        String s2 = "IV";
        String s3 = "IX";
        String s4 = "LVIII";
        String s5 = "MCMXCIV";

        Solution solution = new Solution();

        assertThat(solution.romanToInt(s1)).isEqualTo(3);
        assertThat(solution.romanToInt(s2)).isEqualTo(4);
        assertThat(solution.romanToInt(s3)).isEqualTo(9);
        assertThat(solution.romanToInt(s4)).isEqualTo(58);
        assertThat(solution.romanToInt(s5)).isEqualTo(1994);
    }
}
