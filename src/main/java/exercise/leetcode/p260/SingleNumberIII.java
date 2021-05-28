package exercise.leetcode.p260;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, (integer, integer2) -> integer + 1);
        }

        List<Integer> list = new ArrayList<>();

        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                list.add(key);
                if (list.size() == 2) {
                    break;
                }
            }
        }

        int[] answer = new int[2];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

public class SingleNumberIII {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.singleNumber(new int[]{1, 2, 1, 3, 2, 5})).isEqualTo(new int[]{3, 5});
    }
}
