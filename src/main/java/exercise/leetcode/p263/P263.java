package exercise.leetcode.p263;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    private static final Set<Integer> UGLY_FACTORS = new HashSet<>(Arrays.asList(2, 3, 5));

    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }

        if (num == 1) {
            return true;
        }

        if (UGLY_FACTORS.contains(num)) {
            return true;
        }

        for (int uglyFactor : UGLY_FACTORS) {
            if (isNaturalNumberDivided(num, uglyFactor)) {
                final int i = num / uglyFactor;
                if (isUgly(i)) {
                    UGLY_FACTORS.add(i);
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isNaturalNumberDivided(int num, int uglyFactor) {
        final double i = (double) num / uglyFactor;
        final int j = num / uglyFactor;
        return i - j == 0;
    }
}

public class P263 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.isUgly(6)).isEqualTo(true);
        assertThat(solution.isUgly(8)).isEqualTo(true);
        assertThat(solution.isUgly(14)).isEqualTo(false);
        assertThat(solution.isUgly(0)).isEqualTo(false);
        assertThat(solution.isUgly(1)).isEqualTo(true);
        assertThat(solution.isUgly(9)).isEqualTo(true);

        out.println("p263" + " success!");
    }
}
