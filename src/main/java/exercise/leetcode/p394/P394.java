package exercise.leetcode.p394;

import java.util.Stack;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            final String str = String.valueOf(s.charAt(i));

            if (str.equals(CLOSE_BRACKET)) {
                StringBuilder sb = new StringBuilder();
                String pop = stack.pop();
                while (!pop.equals(OPEN_BRACKET)) {
                    sb.insert(0, pop);
                    pop = stack.pop();
                }

                final int repeatNum = Integer.parseInt(stack.pop());
                final String tmpStr = sb.toString();
                final StringBuilder repeatSb = new StringBuilder();
                for (int j = 0; j < repeatNum; j++) {
                    repeatSb.append(tmpStr);
                }

                stack.push(repeatSb.toString());
                continue;
            }

            stack.push(str);
        }

        final StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            final String pop = stack.pop();
            sb.insert(0, pop);
        }

        return sb.toString();
    }
}

public class P394 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        assertThat(solution.decodeString("3[a]2[bc]")).isEqualTo("aaabcbc");
        assertThat(solution.decodeString("3[a2[c]]")).isEqualTo("accaccacc");
        assertThat(solution.decodeString("2[abc]3[cd]ef")).isEqualTo("abcabccdcdcdef");
        assertThat(solution.decodeString("abc3[cd]xyz")).isEqualTo("abccdcdcdxyz");
        assertThat(solution.decodeString("100[leetcode]")).isEqualTo("leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode");

        out.println("p394" + " success!");
    }
}
