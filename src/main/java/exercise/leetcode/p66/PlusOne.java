package exercise.leetcode.p66;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 시간은 n + (n + 1) = 2n + 1 임으로, O(n)이다. 1ms인데도 하위 10%다.
 * 공간은 n만큼 2개를 사용하여서 O(n)이다. 근데도 37.7% 하위 5%다.
 *
 * 상대적으로 베스트 답안과 차이가 있을뿐이지 절대적인 성능 수치는 아주 낮지 않다. 빅오표기법 짱짱
 */
class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> plusOneDigits = new LinkedList<>();

        digits[digits.length - 1]++;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] >= 10) {
                if (i >= 1) {
                    digits[i - 1]++;
                    plusOneDigits.add(0, digits[i]);
                    continue;
                } else {
                    plusOneDigits.add(0, digits[i]);
                    plusOneDigits.add(0, 1);
                    break;
                }
            }
            plusOneDigits.add(0, digits[i]);
        }

        int[] answer = new int[plusOneDigits.size()];

        for (int i = 0; i < plusOneDigits.size(); i++) {
            int integer = plusOneDigits.get(i);
            answer[i] = integer >= 10 ? 0 : integer;
        }

        return answer;
    }
}

public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.plusOne(new int[]{1, 2, 3})).isEqualTo(new int[]{1, 2, 4});
        assertThat(solution.plusOne(new int[]{4, 3, 2, 1})).isEqualTo(new int[]{4, 3, 2, 2});
        assertThat(solution.plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})).isEqualTo(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 1});
        assertThat(solution.plusOne(new int[]{9})).isEqualTo(new int[]{1, 0});
        assertThat(solution.plusOne(new int[]{9, 9})).isEqualTo(new int[]{1, 0, 0});
    }
}
