package exercise.leetcode.p238;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        boolean hasZeorElement = false;
        int multipleAll = 1;

        for (int num : nums) {
            if (num == 0) {
                hasZeorElement = true;
                continue;
            }

            multipleAll *= num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = multipleAll;
                continue;
            }

            if (hasZeorElement) {
                nums[i] = 0;
                continue;
            }

            nums[i] = multipleAll / nums[i];
        }

        return nums;
    }
}

public class P238 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.productExceptSelf(new int[]{1, 2, 3, 4})).isEqualTo(new int[]{24, 12, 8, 6});
        assertThat(solution.productExceptSelf(new int[]{0, 0})).isEqualTo(new int[]{0, 0});
        assertThat(solution.productExceptSelf(new int[]{1, 0})).isEqualTo(new int[]{0, 1});

        out.println("P238" + " success!");
    }
}
