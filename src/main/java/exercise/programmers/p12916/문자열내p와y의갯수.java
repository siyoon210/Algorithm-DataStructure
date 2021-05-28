package exercise.programmers.p12916;

class Solution {
    boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;

        final String lowerCaseStr = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (lowerCaseStr.charAt(i) == 'p') {
                pCount++;
            } else if (lowerCaseStr.charAt(i) == 'y') {
                yCount++;
            }
        }

        return pCount == yCount;
    }
}

public class 문자열내p와y의갯수 {
    public static void main(String[] args) {
        String s = "pPoooyY";

        Solution solution = new Solution();
        System.out.println("solution.solution(s) = " + solution.solution(s));
    }
}
