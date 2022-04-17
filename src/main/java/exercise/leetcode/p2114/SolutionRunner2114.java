package exercise.leetcode.p2114;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionRunner2114 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.mostWordsFound(
                new String[] {"alice and bob love leetcode", "i think so too",
                              "this is great thanks very much"})).isEqualTo(6);
        assertThat(solution.mostWordsFound(
                new String[] {"please wait", "continue to fight", "continue to win"}))
                .isEqualTo(3);
    }
}
