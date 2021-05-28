package codingTest.cp20.p1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class Solution {
    public int[] solution(int[] arr) {
        Set<Integer> singleNums = new TreeSet<>();
        Set<Integer> duplNums = new HashSet<>();

        for (int i : arr) {
            if (duplNums.contains(i)) {
                singleNums.remove(i);
                continue;
            }

            if (singleNums.contains(i)) {
                singleNums.remove(i);
                duplNums.add(i);
                continue;
            }

            if (!duplNums.contains(i)) {
                singleNums.add(i);
            }
        }

        if (singleNums.size() == 0) {
            return new int[]{-1};
        }

        return singleNums.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

public class P1 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new int[]{2, 1, 3, 3})).isEqualTo(new int[]{1, 2});
        assertThat(solution.solution(new int[]{3, 4, 4, 2, 5, 2, 5, 5})).isEqualTo(new int[]{3});
        assertThat(solution.solution(new int[]{3, 5, 3, 5, 7, 5, 7})).isEqualTo(new int[]{-1});
    }
}