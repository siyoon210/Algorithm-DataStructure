package exercise.programmers.p42862;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Map<Integer, Boolean> lostMap = new HashMap<>();

        for (int i : lost) {
            lostMap.put(i, false);
        }

        Map<Integer, Boolean> reserveMap = new HashMap<>();

        for (int i : reserve) {
            reserveMap.put(i, false);
        }

        for (Map.Entry<Integer, Boolean> lostEntry : lostMap.entrySet()) {
            final int prev = lostEntry.getKey() - 1;
            final int next = lostEntry.getKey() + 1;

            if (reserveMap.containsKey(prev)) {
                reserveMap.remove(prev);
                continue;
            }

            if (reserveMap.containsKey(next)) {
                reserveMap.remove(next);
                continue;
            }

            n -= 1;
        }

        return n;
    }
}

public class P42862 { //체육복
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(5, new int[]{2, 4}, new int[]{1, 3, 5})).isEqualTo(5);
        assertThat(solution.solution(5, new int[]{2, 4}, new int[]{3})).isEqualTo(4);
        assertThat(solution.solution(3, new int[]{3}, new int[]{1})).isEqualTo(2);
    }
}
