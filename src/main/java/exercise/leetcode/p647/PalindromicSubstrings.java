package exercise.leetcode.p647;

class Solution {
    public int countSubstrings(String s) {
        int subStrCount = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (j - i == 1) {
                    subStrCount++;
                    continue;
                }
                if (isPalindromeStr(s.substring(i,j))) {
                    subStrCount++;
                }
            }
        }

        return subStrCount;
    }

    private boolean isPalindromeStr(String str) {
        int pointer1 = 0;
        int pointer2 = str.length() - 1;

        while (pointer1 < pointer2) {
            if (str.charAt(pointer1) != str.charAt(pointer2)) {
                return false;
            }
            pointer1++;
            pointer2--;
        }

        return true;
    }
}

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String s1 = "abc"; // 3
        String s2 = "aaa"; // 6

        Solution solution = new Solution();
        System.out.println("solution.countSubstrings(s) = " + solution.countSubstrings(s1));
    }
}
