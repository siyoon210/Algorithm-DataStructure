package codingTest.wooa.wb2012.p3;

import java.util.HashSet;
import java.util.Set;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int solution(int[] A) {
        int max = 0;
        Set<Integer> numbers = new HashSet<>();

        for (int num : A) {
            if (numbers.contains(oppositeNumber(num))) {
                max = Math.max(max, Math.abs(num));
            }
            numbers.add(num);
        }

        return max;
    }

    private int oppositeNumber(int number) {
        return number * -1;
    }
}

public class P3 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new int[]{3, 2, -2, 5, -3})).isEqualTo(3);
        assertThat(solution.solution(new int[]{1, 1, 2, -1, 2, -1})).isEqualTo(1);
        assertThat(solution.solution(new int[]{1, 2, 3, -4})).isEqualTo(0);
        assertThat(solution.solution(new int[]{-1000000000,1000000000})).isEqualTo(0);

        out.println("p3" + " success!");
    }
}
