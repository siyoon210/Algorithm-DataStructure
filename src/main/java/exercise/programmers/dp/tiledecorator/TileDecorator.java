package exercise.programmers.dp.tiledecorator;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

// N번째와 N-1번째 타일의 길이를 알아낸다
// 두 길이의 합을 2배하면 둘레다.
class Solution {
    private final long[] length = new long[80];

    public Solution() {
        length[0] = 1;
        length[1] = 1;
    }

    public long solution(int N) {
        final long lengthPreN = getLengthIndexOf(N - 2);
        final long lengthN = getLengthIndexOf(N - 1);
        return (lengthN + lengthN + lengthPreN) * 2;
    }

    private long getLengthIndexOf(int index) {
        if (index < 0) {
            return length[0];
        }

        if (length[index] != 0) {
            return length[index];
        }

        length[index] = getLengthIndexOf(index - 1) + getLengthIndexOf(index - 2);
        return length[index];
    }
}

public class TileDecorator {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(2)).isEqualTo(6);
        assertThat(solution.solution(5)).isEqualTo(26);
        assertThat(solution.solution(6)).isEqualTo(42);

        out.println("TileDeco" + " success!");
    }
}
