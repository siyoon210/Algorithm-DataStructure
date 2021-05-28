package exercise.leetcode.p22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    List<String> answer;
    int n ;
    int openBracketNum ;
    int closeBracketNum;

    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        this.n = n;
        openBracketNum = 0;
        closeBracketNum = 0;

        generate("");
        return answer;
    }

    private void generate(String parenthesis) {
        if (openBracketNum < n) {
            openBracketNum++;
            generate(parenthesis + "(");
            openBracketNum--;
        }

        if (closeBracketNum < openBracketNum) {
            closeBracketNum++;
            generate(parenthesis + ")");
            closeBracketNum--;
        }

        if (openBracketNum == n && closeBracketNum == n) {
            answer.add(parenthesis);
        }
    }
}

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.generateParenthesis(3))
                .isEqualTo(
                        Arrays.asList(
                                "((()))",
                                "(()())",
                                "(())()",
                                "()(())",
                                "()()()"));
    }
}
