package exercise.leetcode.p844;

import java.util.Stack;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return applyBackSpace(S).equals(applyBackSpace(T));
    }

    private String applyBackSpace(String str) {
        final char BACKSPACE_CHAR = '#';
        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == BACKSPACE_CHAR) {
                if (!characterStack.empty()) {
                    characterStack.pop();
                }
                continue;
            }

            characterStack.push(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        while (!characterStack.empty()) {
            sb.insert(0, characterStack.pop());
        }

        return sb.toString();
    }
}

public class P844 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.backspaceCompare("ab#c","ad#c")).isEqualTo(true);
        assertThat(solution.backspaceCompare("ab##","c#d#")).isEqualTo(true);
        assertThat(solution.backspaceCompare("a##c","#a#c")).isEqualTo(true);
        assertThat(solution.backspaceCompare("a#c","b")).isEqualTo(false);
        assertThat(solution.backspaceCompare("y#fo##f","y#f#o##f")).isEqualTo(true);

        out.println("p844" + " success!");
    }
}
