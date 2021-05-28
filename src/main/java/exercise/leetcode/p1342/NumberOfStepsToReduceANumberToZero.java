package exercise.leetcode.p1342;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int numberOfSteps(int num) {
        int step = 0;
        while (num != 0) {
            if (isEvenNumber(num)) {
                num /= 2;
            } else {
                num -= 1;
            }
            step++;
        }

        return step;
    }

    private boolean isEvenNumber(int num) {
        return num % 2 == 0;
    }
}

public class NumberOfStepsToReduceANumberToZero {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.numberOfSteps(14)).isEqualTo(6);
        assertThat(solution.numberOfSteps(8)).isEqualTo(4);
    }
}
