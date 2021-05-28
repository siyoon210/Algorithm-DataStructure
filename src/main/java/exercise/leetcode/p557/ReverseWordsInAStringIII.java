package exercise.leetcode.p557;

import java.util.Stack;

class Solution {
    public String reverseWords(String s) {
        Stack<Character> characters = new Stack<>();
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                characters.push(s.charAt(i));
            } else {
                appendChars(characters, stringBuffer);
                stringBuffer.append(' ');
            }
        }

        appendChars(characters, stringBuffer);

        return stringBuffer.toString();
    }

    private void appendChars(Stack<Character> characters, StringBuffer stringBuffer) {
        while (!characters.empty()) {
            stringBuffer.append(characters.pop());
        }
    }
}

public class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        Solution solution = new Solution();
        System.out.println(solution.reverseWords(s));
    }
}
