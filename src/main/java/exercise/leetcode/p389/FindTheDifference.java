package exercise.leetcode.p389;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> charAndCountMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charAndCountMap.containsKey(c)) {
                charAndCountMap.put(c, charAndCountMap.get(c) + 1);
                continue;
            }
            charAndCountMap.put(c, 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!charAndCountMap.containsKey(c) || charAndCountMap.get(c) <= 0) {
                return c;
            }

            charAndCountMap.put(c, charAndCountMap.get(c) -1);
        }

        return 0;
    }
}

public class FindTheDifference {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";

        Solution solution = new Solution();
        System.out.println(solution.findTheDifference(s, t));
    }
}
