package exercise.leetcode.p1025;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public boolean divisorGame(int N) {
        boolean aliceWin = false;
        int x;

        while (true) {
            x = getX(N);
            if (x == -1) {
                break;
            }
            N -= x;
            aliceWin = !aliceWin;
        }

        return aliceWin;
    }

    private int getX(int N) {
        for (int i = 1; i < N; i++) {
            if (isProperNumber(N, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isProperNumber(int N, int x) {
        return N % x == 0;
    }
}

public class P1025 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        assertThat(solution.divisorGame(2)).isEqualTo(true);
        assertThat(solution.divisorGame(3)).isEqualTo(false);

        out.println("p1025" + " success!");
    }
}
