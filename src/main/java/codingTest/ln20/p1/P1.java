package codingTest.ln20.p1;

import java.util.*;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int solution(String string) {
        final Set<String> openBracket = new HashSet<>(Arrays.asList("(", "[", "{", "<"));
        final Set<String> closeBracket = new HashSet<>(Arrays.asList(")", "]", "}", ">"));

        final Stack<String> openBrackets = new Stack<>();
        final Stack<String> tmpBrackets = new Stack<>();
        int answer = 0;

        final String[] split = string.split("");
        for (String s : split) {
            if (openBracket.contains(s)) {
                openBrackets.push(s);
                continue;
            }

            if (closeBracket.contains(s)) {
                if (hasPair(openBrackets, tmpBrackets, s)) {
                    answer++;
                } else {
                    return -1;
                }
            }
        }

        return answer;
    }

    private boolean hasPair(Stack<String> openBrackets, Stack<String> tmpBrackets, String close) {
        while (!openBrackets.empty()) {
            final String pop = openBrackets.pop();
            if (isProperPair(pop, close)) {
                rollbackOpenBrackets(openBrackets, tmpBrackets);
                return true;
            }

            tmpBrackets.push(pop);
        }

        return false;
    }

    private void rollbackOpenBrackets(Stack<String> openBrackets, Stack<String> tmpBrackets) {
        while (!tmpBrackets.empty()) {
            openBrackets.push(tmpBrackets.pop());
        }
    }

    private boolean isProperPair(String pop, String close) {
        return pop.equals("(") && close.equals(")") ||
                pop.equals("[") && close.equals("]") ||
                pop.equals("{") && close.equals("}") ||
                pop.equals("<") && close.equals(">");
    }
}

public class P1 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution("Hello, world!")).isEqualTo(0);
        assertThat(solution.solution("line [plus]")).isEqualTo(1);
        assertThat(solution.solution("if (Count of eggs is 4.) {Buy mill.}")).isEqualTo(2);
        assertThat(solution.solution(">_<")).isEqualTo(-1);
        assertThat(solution.solution("([)]")).isEqualTo(2);

        out.println("P1" + " success!");
    }
}
