package exercise.leetcode.p78;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        boolean[] flag = new boolean[nums.length];
        findSubset(flag, 0);

        return answer;
    }

    private void findSubset(boolean[] flag, int depth) {
        if (depth == flag.length) {
            final List<Integer> integers = new ArrayList<>();
            for (int i = 0; i < flag.length; i++) {
                if (flag[i]) {
                    integers.add(nums[i]);
                }
            }

            answer.add(integers);
            return;
        }

        //true
        flag[depth] = true;
        findSubset(flag, depth + 1);

        //false
        flag[depth] = false;
        findSubset(flag, depth + 1);
    }
}

public class P78 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        final List<List<Integer>> subsets = solution.subsets(new int[]{1, 2, 3});
        assertThat(subsets.size()).isEqualTo(8);

        out.println("P78" + " success!");
    }
}
