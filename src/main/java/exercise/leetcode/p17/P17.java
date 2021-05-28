package exercise.leetcode.p17;

import java.util.*;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    private final Map<Character, List<String>> letters = new HashMap<>();
    private String digits;
    private List<String> answer;

    public Solution() {
        letters.put('2', Arrays.asList("a", "b", "c"));
        letters.put('3', Arrays.asList("d", "e", "f"));
        letters.put('4', Arrays.asList("g", "h", "i"));
        letters.put('5', Arrays.asList("j", "k", "l"));
        letters.put('6', Arrays.asList("m", "n", "o"));
        letters.put('7', Arrays.asList("p", "q", "r", "s"));
        letters.put('8', Arrays.asList("t", "u", "v"));
        letters.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        answer = new ArrayList<>();
        if (digits.length() == 0) {
            return answer;
        }

        this.digits = digits;
        dfs(new StringBuilder(), 0);
        return answer;
    }

    private void dfs(StringBuilder stringBuilder, int i) {
        if (i >= digits.length()) {
            answer.add(stringBuilder.toString());
            return;
        }

        final List<String> strings = letters.get(digits.charAt(i));
        for (String string : strings) {
            stringBuilder.append(string);
            final int index = stringBuilder.length() - 1;
            dfs(stringBuilder, i + 1);
            stringBuilder.delete(index, index + 1);
        }
    }
}

public class P17 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.letterCombinations("23").size()).isEqualTo(9);

        out.println("p17" + " success!");
    }
}
