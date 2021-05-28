package codingTest.zm20.p2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class Solution {
    public int solution(int[] A) {
        int answer = Integer.MIN_VALUE;
        Map<Integer, TreeSet<Integer>> digitSumAndOriginMap = new HashMap<>();
        for (int i : A) {
            int digitSum = getDigitSum(i);
            if (digitSumAndOriginMap.containsKey(digitSum)) {
                digitSumAndOriginMap.get(digitSum).add(i);
            } else {
                TreeSet<Integer> origins = new TreeSet<>(Comparator.reverseOrder());
                origins.add(i);
                digitSumAndOriginMap.put(digitSum, origins);
            }
        }

        boolean existSum = false;
        for (Map.Entry<Integer, TreeSet<Integer>> integerTreeSetEntry : digitSumAndOriginMap.entrySet()) {
            TreeSet<Integer> origins = integerTreeSetEntry.getValue();
            if (origins.size() < 2) {
                continue;
            }

            existSum = true;
            Integer first = origins.pollFirst();
            Integer second = origins.pollFirst();

            answer = Math.max(answer, first + second);
        }

        return existSum ? answer : -1;
    }

    private int getDigitSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }

        return sum;
    }
}

public class P {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new int[]{51, 71, 17, 42})).isEqualTo(93);
        assertThat(solution.solution(new int[]{42, 33, 60})).isEqualTo(102);
        assertThat(solution.solution(new int[]{51, 32, 43})).isEqualTo(-1);
    }
}