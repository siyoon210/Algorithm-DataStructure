package exercise.leetcode.p39;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    List<List<Integer>> answer;
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.answer = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        dfsTraversal(null, 0);
        return answer;
    }

    private void dfsTraversal(List<Integer> list, int index) {
        if (Objects.isNull(list)) {
            list = new ArrayList<>();
        }

        final Integer sum = list.stream().reduce(0, Integer::sum);
        if (sum == target) {
            answer.add(new ArrayList<>(list));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            final Integer candidate = candidates[i];
            list.add(candidate);
            dfsTraversal(list, i);
            list.remove(candidate);
        }
    }
}

public class P39 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.combinationSum(new int[]{2, 3, 6, 7}, 7).size()).isEqualTo(2);
        assertThat(solution.combinationSum(new int[]{2, 3, 5}, 8).size()).isEqualTo(3);

        out.println("p39" + " success!");
    }
}
