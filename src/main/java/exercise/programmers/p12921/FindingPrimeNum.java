package exercise.programmers.p12921;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int solution(int n) {
        final Map<Integer, Boolean> nums = initNums(n);

        for (int i = 2; i <= n; i++) {
            if (nums.containsKey(i)) {
                //지금 i를 제외한 모든 배수를 삭제
                for (int j = 2; i * j <= n; j++) {
                    nums.remove(i * j);
                }
            }
        }

        return nums.size();
    }

    private Map<Integer, Boolean> initNums(int n) {
        Map<Integer, Boolean> nums = new HashMap<>();

        for (int i = 2; i <= n; i++) {
            nums.put(i, false);
        }

        return nums;
    }
}

public class FindingPrimeNum {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(5)).isEqualTo(3);
        assertThat(solution.solution(10)).isEqualTo(4);
    }
}
