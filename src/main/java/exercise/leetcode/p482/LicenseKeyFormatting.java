package exercise.leetcode.p482;


import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        String[] group = S.split("-");

        for (int i = 0; i < group.length; i++) {
            group[i] = group[i].toUpperCase();
        }

        StringBuilder answer = new StringBuilder();

        int index = group.length - 1;

        while (index >= 0) {
            StringBuilder tmpSb = new StringBuilder();

            while (index >= 0 && (tmpSb.toString().length() + group[index].length()) <= K) {
                tmpSb.insert(0, group[index]);
                index--;
            }

            if (answer.toString().length() > 0) {
                answer.insert(0, "-");
            }
            answer.insert(0, tmpSb);
        }

        return answer.toString();
    }
}

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        String S = "5F3Z-2e-9-w";
        int K = 4;

        Solution solution = new Solution();
        solution.licenseKeyFormatting(S, K);
        assertThat(solution.licenseKeyFormatting(S, K)).isEqualTo("5F3Z-2E9W");
        assertThat(solution.licenseKeyFormatting("2-4A0r7-4k", 4)).isEqualTo("?");
    }
}
