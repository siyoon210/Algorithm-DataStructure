package codingTest.llst.gm2009.p3;

import java.util.Arrays;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int solution(int[] A) {
        int answer = 0;
        //배열을 정렬한다. O(nlogn)
        Arrays.sort(A);
        //순회하면서 인덱스에 존재해야할 숫자로 조정한다 O(n)
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                answer += Math.abs(A[i] - (i + 1));
            }
        }
        //1_000_000_000보다 커지면 -1을 리턴
        return answer > 1_000_000_000 ? -1 : answer;
    }
}

public class P3 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new int[]{1, 2, 1})).isEqualTo(2);
        assertThat(solution.solution(new int[]{2, 1, 4, 4})).isEqualTo(1);
        assertThat(solution.solution(new int[]{6, 2, 3, 5, 6, 3})).isEqualTo(4);

        out.println("p3" + " success!");
    }
}
