package codingTest.zm20.p1;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class Solution {
    public int solution(int[] A) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : A) {
            map.merge(i, 1, (integer, integer2) -> integer + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                answer = Math.max(answer, entry.getKey());
            }
        }

        return answer;
    }
}

public class P {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new int[]{3, 8, 2, 3, 3, 2})).isEqualTo(3);
        assertThat(solution.solution(new int[]{7, 1, 2, 8, 2})).isEqualTo(2);
        assertThat(solution.solution(new int[]{3, 1, 4, 1, 5})).isEqualTo(0);
        assertThat(solution.solution(new int[]{5, 5, 5, 5, 5})).isEqualTo(5);
    }
}