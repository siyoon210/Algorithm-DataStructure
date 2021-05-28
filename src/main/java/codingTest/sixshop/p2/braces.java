package codingTest.sixshop.p2;

import java.util.Scanner;
import java.util.Stack;

class Result{
    enum OpenBrace{
        Large('['), Medium('{'), Small('(');
        private char charValue;

        OpenBrace(char charValue) {
            this.charValue = charValue;
        }
    }

    enum CloseBrace{
        Large(']'), Medium('}'), Small(')');
        private char charValue;

        CloseBrace(char charValue) {
            this.charValue = charValue;
        }
    }

    static String[] braces(String[] values) {
        Stack<Character> characterStack;
        String[] answer = new String[values.length];

        for (int i = 0; i < values.length; i++) {
            characterStack = new Stack<>();
            if (isBalanced(characterStack, values[i])) {
                answer[i] = "YES";
            } else {
                answer[i] = "NO";
            }
        }

        return answer;
    }

    private static boolean isBalanced(Stack<Character> characterStack, String value) {
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (isOpenBrace(c)) {
                characterStack.push(c);
            } else {
                if (characterStack.empty()) return false;

                if (!isPairBrace(characterStack.pop(), c)) return false;
            }
        }
        return characterStack.empty();
    }

    private static boolean isOpenBrace(char c) {
        if (c == OpenBrace.Large.charValue) {
            return true;
        } else if (c == OpenBrace.Medium.charValue) {
            return true;
        } else {
            return c == OpenBrace.Small.charValue;
        }
    }

    private static boolean isPairBrace(char frontChar, char backSideChar) {
        if ((frontChar == OpenBrace.Large.charValue) && (backSideChar == CloseBrace.Large.charValue)) {
            return true;
        } else if ((frontChar == OpenBrace.Medium.charValue) && (backSideChar == CloseBrace.Medium.charValue)) {
            return true;
        } else {
            return (frontChar == OpenBrace.Small.charValue) && (backSideChar == CloseBrace.Small.charValue);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);
}
public class braces {
    public static void main(String[] args) {
        String[] values = {
                "[",
                "{{[[(())]]}}"
        };

        for (String brace : Result.braces(values)) {
            System.out.println(brace);

        }
    }
}
