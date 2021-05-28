package codingTest.cp20.p2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class Solution {
    public int solution(int[][] p) {
        int answer = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] ints : p) {
            if (map.containsKey(ints[0])) {
                map.get(ints[0]).add(ints[1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(ints[1]);
                map.put(ints[0], set);
            }

            if (map.containsKey(ints[1]) && map.get(ints[1]).contains(ints[0])) {
                answer++;
            }
        }

        return answer;
    }
}

public class P2 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new int[][]{{1, 3}, {3, 1}, {3, 5}, {2, 5}, {5, 3}})).isEqualTo(2);
    }
}
