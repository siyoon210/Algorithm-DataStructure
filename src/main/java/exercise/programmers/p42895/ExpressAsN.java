package exercise.programmers.p42895;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    private int N;
    private int number;
    private int answer = Integer.MAX_VALUE;

    public int solution(int N, int number) {
        this.N = N;
        this.number = number;

        dfs(0, 0);

        if (answer > 8) {
            return -1;
        }

        return answer;
    }

    void dfs(int usageCount, int tmpNum) {
        if (usageCount > 8) {
            return;
        }

        if (tmpNum == number) {
            answer = Math.min(answer, usageCount);
        }

        int tmp = 0;
        for (int i = 0; i < 8; i++) {
            tmp = tmp * 10 + N;
            dfs(usageCount + i + 1, tmpNum + tmp);
            dfs(usageCount + i + 1, tmpNum - tmp);
            dfs(usageCount + i + 1, tmpNum * tmp);
            dfs(usageCount + i + 1, tmpNum / tmp);
        }
    }
}

/**
 * 1. 1개만 이용해서 만들어 본다. -> 5
 * 2. 2개만 이용해서 만들어 본다. -> 55, 5+5, 5-5, 5*5, 5/5 (총 다섯가지가 나온다.) (1과 1의 조합)
 * 3. 3개만 이용해서 만들어 본다. -> 555, 55+5, 55-5, 55*5, 55/5 (이것은 2와 1의 조합이다.)
 * 4. 4개만 이용해서 만들어 본다. -> 5555, 555+5, 555-5, 555*5. 555/5, 55+55, 55-55, 55*55. 55/55 (이것은 3과 1의 조합 + 2와 2의조합이다.)
 * 5. 5개만 이용해서 만들어 본다. -> (4 1 조합, 3 2 조합)
 * 6. 6개만 이용해서 만들어 본다. -> (5 1 조합, 4 2 조합, 3 3 조합)
 * 7. 7개만 이용해서 만들어 본다. -> (6 1 조합, 5 2 조합, 4 3 조합)
 * 8. 리턴 -1
 */
public class ExpressAsN {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(5, 12)).isEqualTo(4);
        assertThat(solution.solution(2, 11)).isEqualTo(3);
    }
}
