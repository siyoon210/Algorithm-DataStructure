package exercise.leetcode.p1678;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public String interpret(String command) {
        var sb = new StringBuilder();
        for (var i = 0; i < command.length(); ) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
                i++;
            } else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                sb.append('o');
                i += 2;
            } else if (command.charAt(i) == '('&& command.charAt(i + 1) == 'a') {
                sb.append("al");
                i += 4;
            }
        }
        return sb.toString();
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
