package exercise.leetcode.p242;

import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        //1. 렝쓰를 비교한다
        if (s.length() != t.length()) {
            return false;
        }
        //2. 해쉬코드로 비교한다.
        //3. 정렬하고 하나씩 비교한다.
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }

        return true;
    }
}

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        Solution solution = new Solution();
        boolean anagram = solution.isAnagram(s, t);
        System.out.println(anagram);
    }
}
