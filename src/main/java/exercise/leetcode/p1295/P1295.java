package exercise.leetcode.p1295;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}

public class P1295 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.findNumbers(new int[]{12, 345, 2, 6, 7896})).isEqualTo(2);
        assertThat(solution.findNumbers(new int[]{555, 901, 482, 1771})).isEqualTo(1);
    }
}
