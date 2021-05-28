package exercise.estsoft.codility201901.p2;

import java.util.Stack;

class Solution {
    public String solution(String S) {
        Stack<Character> stack = new Stack<>();

        char[] chars = S.toCharArray();
        stack.push(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            if (!stack.empty() && (stack.peek() == chars[i])) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }

        Stack<Character> tmpStack = new Stack<>();

        while (!stack.empty()) {
            tmpStack.push(stack.pop());
        }

        StringBuilder answer = new StringBuilder();
        while (!tmpStack.empty()) {
            answer.append(tmpStack.pop());
        }
        return answer.toString();
    }
}

public class TransformationString {
    public static void main(String[] args) {
//        String S = "ACCAABBC";
        String S = "ABCBBCBA";

        Solution solution = new Solution();
        System.out.println(solution.solution(S));
    }
}
