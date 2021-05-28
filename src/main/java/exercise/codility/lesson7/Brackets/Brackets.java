package exercise.codility.lesson7.Brackets;

import java.util.Stack;

class Solution {
    enum OpenBracket {
        LARGE('['), MEDIUM('{'), SMALL('(');

        private final char charValue;

        OpenBracket(char charValue) {
            this.charValue = charValue;
        }
    }

    enum CloseBracket {
        LARGE(']'), MEDIUM('}'), SMALL(')');

        private final char charValue;

        CloseBracket(char charValue) {
            this.charValue = charValue;
        }
    }

    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        boolean isNested = false;

        //S의 케릭터배열로 바꿔서 반복시행한다.
        char[] chars = S.toCharArray();
        for (char aChar : chars) {
            //만약 여는 괄호라면 스택에 넣는다.
            if (isOpenBracket(aChar)) {
                stack.push(aChar);
                isNested = true;
            } else if (isCloseBracket(aChar)) { //만약 닫는 괄호라면 스택에서 하나 뺀다.
                //스택에서 하나 빼는, 1. 스택이 비어있거나, 2. 짝이 맞는 여는 괄호가 아닌 경우는 false다!
                if (stack.empty()) {
                    return 0;
                }
                Character popChar = stack.pop();

                if (!isPairBracket(popChar, aChar)) {
                    return 0;
                }
            } else {//괄호가 아니고 문자열인 경우 감싸져있었는지 확인한다.
                if (!isNested) {
                    return 0;
                }
            }

        }


        //스택이 비어있는지 확인하고 리턴
        return stack.empty() ? 1 : 0;
    }

    private boolean isOpenBracket(char c) {
        return c == OpenBracket.LARGE.charValue || c == OpenBracket.MEDIUM.charValue || c == OpenBracket.SMALL.charValue;
    }

    private boolean isCloseBracket(char c) {
        return c == CloseBracket.LARGE.charValue || c == CloseBracket.MEDIUM.charValue || c == CloseBracket.SMALL.charValue;
    }

    private boolean isPairBracket(char frontChar, char rearChar) {
        if (frontChar == OpenBracket.LARGE.charValue && rearChar == CloseBracket.LARGE.charValue) {
            return true;
        } else if (frontChar == OpenBracket.MEDIUM.charValue && rearChar == CloseBracket.MEDIUM.charValue) {
            return true;
        }

        return frontChar == OpenBracket.SMALL.charValue && rearChar == CloseBracket.SMALL.charValue;
    }
}

public class Brackets {
    public static void main(String[] args) {
        String S = "asd";

        Solution solution = new Solution();
        System.out.println(solution.solution(S));
    }
}
