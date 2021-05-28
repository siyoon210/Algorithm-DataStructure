package exercise.kakaoblind2019.p1;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        //1개씩 자르기부터, 문자열의 길이만큼 자르기 까지
        //i개 만큼씩 자르겠다.
        for (int subSize = 1; subSize < s.length(); subSize++) {
            List<String> subStrs = getSubStrings(s, subSize);

            StringBuilder sb = new StringBuilder();
            String baseStr = "";
            int equalStrCount = 1;

            for (String subStr : subStrs) {
                if (baseStr.equals(subStr)) {
                    equalStrCount++;
                    continue;
                }
                appendCompressionStr(sb, baseStr, equalStrCount);

                equalStrCount = 1;
                baseStr = subStr;
            }

            appendCompressionStr(sb, baseStr, equalStrCount);
            System.out.println("sb.toString() = " + sb.toString());
            answer = Math.min(answer, sb.toString().length());
        }

        return answer;
    }

    private List<String> getSubStrings(String s, final int subSize) {
        List<String> subStrs = new ArrayList<>();

        while (s.length() > 0) {
            if (subSize < s.length()) {
                String substring = s.substring(0, subSize);
                s = s.substring(subSize);
                subStrs.add(substring);
            } else {
                subStrs.add(s);
                break;
            }
        }

        return subStrs;
    }

    private void appendCompressionStr(final StringBuilder sb, final String baseStr, final int equalStrCount) {
        if (equalStrCount == 1) {
            sb.append(baseStr);
        } else {
            sb.append(equalStrCount).append(baseStr);
        }
    }
}

public class P1 {
    public static void main(String[] args) {
        String s = "ababcdcdababcdcd";//9

        Solution solution = new Solution();
        System.out.println("solution.solution(s) = " + solution.solution(s));
    }
}
