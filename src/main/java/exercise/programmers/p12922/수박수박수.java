package exercise.programmers.p12922;

class Solution {
    public String solution(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (i % 2==0) {
                stringBuilder.append("수");
            } else {
                stringBuilder.append("박");
            }
        }

        return stringBuilder.toString();
    }
}

public class 수박수박수 {
    public static void main(String[] args) {
        int n = 4;

        Solution solution = new Solution();
        System.out.println("solution.solution(n) = " + solution.solution(n));
    }
}
