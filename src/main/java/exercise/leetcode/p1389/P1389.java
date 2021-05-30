package exercise.leetcode.p1389;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> targetList = new ArrayList<>();
        for (var i = 0; i < nums.length; i++) {
            targetList.add(index[i], nums[i]);
        }
        return targetList.stream().mapToInt(i -> i).toArray();
    }
}

public class P1389 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1}))
                .isEqualTo(new int[]{0, 4, 1, 3, 2});
        assertThat(solution.createTargetArray(new int[]{1, 2, 3, 4, 0}, new int[]{0, 1, 2, 3, 0}))
                .isEqualTo(new int[]{0, 1, 2, 3, 4});
        assertThat(solution.createTargetArray(new int[]{1}, new int[]{0}))
                .isEqualTo(new int[]{1});
    }
}
