package exercise.programmers.p12903;

class Solution {
    public String solution(String s) {
        int centerIdx = s.length() / 2;
        if (isEvenNumber(s.length())) {
            return s.substring(centerIdx - 1, centerIdx + 1);
        }

        return String.valueOf(s.charAt(centerIdx));
    }

    private boolean isEvenNumber(final int num) {
        return num % 2 == 0;
    }
}

public class 가운데글자가져오기 {
    public static void main(String[] args) {
        String s1 = "abcde"; //c
        String s2 = "qwer"; // we
        String s3 = "12345678"; // 45

        Solution solution = new Solution();
        System.out.println("solution.solution(s) = " + solution.solution(s1));
    }
}
