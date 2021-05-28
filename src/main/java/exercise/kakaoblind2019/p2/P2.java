package exercise.kakaoblind2019.p2;

import java.util.Stack;

class Solution {
    static class PairUV {
        String u = "";
        String v = "";

        PairUV(final String u, final String v) {
            this.u += u;
            this.v += v;
        }

        String refineU() {
            if (u.length() >= 2) {
                u = u.substring(1, u.length() - 1);
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') {
                    sb.append(')');
                } else if (u.charAt(i) == ')') {
                    sb.append('(');
                }
            }

            u = sb.toString();

            return this.u;
        }
    }

    public String solution(String p) {
        if (isRight(p)) {
            return p;
        }

        return getRightStr(p);
    }

    private String getRightStr(String str) {
        for (int i = 1; i <= str.length(); i++) {
            String u = str.substring(0, i);
            if (!isBalanced(u)) {
                continue;
            }

            PairUV pairUV = new PairUV(u, str.substring(i));

            if (isRight(pairUV.u)) {
                pairUV.v = getRightStr(pairUV.v);
                return pairUV.u + pairUV.v;
            } else {
                return "(" + getRightStr(pairUV.v) + ")" + pairUV.refineU();
            }
        }

        return "";
    }

    boolean isBalanced(String str) {
        int openedCount = 0;
        int closedCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                openedCount++;
            } else if (str.charAt(i) == ')') {
                closedCount++;
            }
        }
        return openedCount == closedCount;
    }

    boolean isRight(String str) {
        if (!isBalanced(str)) {
            return false;
        }

        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                characterStack.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                if (characterStack.isEmpty()) {
                    return false;
                }

                characterStack.pop();
            }
        }

        return characterStack.isEmpty();
    }
}

public class P2 {
    public static void main(String[] args) {
        String p = ")(";

        Solution solution = new Solution();
        System.out.println("solution.solution(p) = " + solution.solution(p));
    }
}
