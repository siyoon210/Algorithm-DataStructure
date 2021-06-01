package exercise.leetcode.p1678;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public String interpret(String command) {
        return command.replace("(al)", "al").replace("()", "o");
    }
}

public class P1678 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.interpret("G()(al)")).isEqualTo("Goal");
        assertThat(solution.interpret("G()()()()(al)")).isEqualTo("Gooooal");
        assertThat(solution.interpret("(al)G(al)()()G")).isEqualTo("alGalooG");
    }
}
