package exercise.leetcode.p347;

import java.util.*;
import java.util.function.ToIntFunction;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> set = new TreeSet<>(Comparator
                .comparingInt((ToIntFunction<Map.Entry<Integer, Integer>>) Map.Entry::getValue)
                .reversed()
                .thenComparingInt(Map.Entry::getKey));

        set.addAll(map.entrySet());

        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();

        List<Integer> answer = new ArrayList<>(k);

        for (int i = 0; i < k; i++) {
            answer.add(iterator.next().getKey());
        }

        return answer;
    }
}

public class P347 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        final List<Integer> case1 = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        assertThat(case1.size()).isEqualTo(2);
        assertThat(case1.get(0)).isEqualTo(1);
        assertThat(case1.get(1)).isEqualTo(2);

        final List<Integer> case2 = solution.topKFrequent(new int[]{1}, 1);
        assertThat(case2.size()).isEqualTo(1);
        assertThat(case2.get(0)).isEqualTo(1);

        final List<Integer> case3 = solution.topKFrequent(new int[]{-1, -1}, 1);
        assertThat(case3.size()).isEqualTo(1);
        assertThat(case3.get(0)).isEqualTo(-1);

        final List<Integer> case4 = solution.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
        assertThat(case4.size()).isEqualTo(2);
        assertThat(case4.get(0)).isEqualTo(-1);
        assertThat(case4.get(1)).isEqualTo(2);
    }
}
