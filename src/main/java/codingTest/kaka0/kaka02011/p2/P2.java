package codingTest.kaka0.kaka02011.p2;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public static int solution(List<Integer> arr) {
        int minValue = arr.get(0);
        int maxDiff = -1;

        if (arr.size() <= 1) {
            return maxDiff;
        }

        for (int i = 1; i < arr.size(); i++) {
            Integer currNumber = arr.get(i);
            minValue = Math.min(minValue, currNumber);
            if (currNumber > minValue) {
                maxDiff = Math.max(maxDiff, currNumber - minValue);
            }
        }

        return maxDiff;
    }
}

public class P2 {
    public static void main(String[] args) {
//        assertThat(Solution.solution(Arrays.asList(5, 3, 6, 7, 4))).isEqualTo(4);
        assertThat(Solution.solution(Arrays.asList(4, 3, 2, 1))).isEqualTo(-1);
        assertThat(Solution.solution(Arrays.asList(2, 3, 10, 2, 4, 8, 1))).isEqualTo(8);
        assertThat(Solution.solution(Arrays.asList(7, 9, 5, 6, 3, 2))).isEqualTo(2);

        //경계값
        assertThat(Solution.solution(Arrays.asList(7))).isEqualTo(-1);

        out.println("p2" + " success!");
    }
}
