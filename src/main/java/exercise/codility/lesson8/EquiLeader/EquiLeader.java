package exercise.codility.lesson8.EquiLeader;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int solution(int[] A) {
        int answer = 0;
        final Map<Integer, Integer> leftValueAndCount = new HashMap<>();
        final Map<Integer, Integer> rightValueAndCount = initRightValueAndCountMap(A);

        for (int i = 0; i < A.length; i++) {
            adjustLeftAndRight(A[i], leftValueAndCount, rightValueAndCount);

            final Integer leftLeader = findLeftLeader(leftValueAndCount, i);
            if (leftLeader == null) {
                continue;
            }

            if (rightValueAndCount.containsKey(leftLeader) && rightValueAndCount.get(leftLeader) > (A.length - 1 - i) / 2) {
                answer++;
            }
        }


        return answer;
    }

    private Integer findLeftLeader(final Map<Integer, Integer> leftValueAndCount, final int i) {
        for (final Map.Entry<Integer, Integer> entry : leftValueAndCount.entrySet()) {
            if (entry.getValue() > (i + 1) / 2) {
                return entry.getKey();
            }
        }

        return null;
    }

    private void adjustLeftAndRight(final int key, final Map<Integer, Integer> leftValueAndCount, final Map<Integer, Integer> rightValueAndCount) {
        leftValueAndCount.merge(key, 1, (count, count2) -> count + 1);

        if (rightValueAndCount.containsKey(key)) {
            final Integer value = rightValueAndCount.get(key);
            if (rightValueAndCount.get(key) > 1) {
                rightValueAndCount.put(key, value - 1);
            } else {
                rightValueAndCount.remove(key);
            }
        }
    }

    private Map<Integer, Integer> initRightValueAndCountMap(final int[] A) {
        Map<Integer, Integer> rightValueAndCount = new HashMap<>();

        for (final int value : A) {
            rightValueAndCount.merge(value, 1, (count, count2) -> count + 1);
        }
        return rightValueAndCount;
    }
}


public class EquiLeader {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new int[]{4, 3, 4, 4, 4, 2})).isEqualTo(3);
    }
}
