package exercise.leetcode.p884;

import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");

        Map<String, Boolean> wordAndUncommoned = new HashMap<>();

        checkUncommon(wordsA, wordAndUncommoned);
        checkUncommon(wordsB, wordAndUncommoned);


        List<String> stringList = new ArrayList<>();

        for (String s : wordAndUncommoned.keySet()) {
            if (wordAndUncommoned.get(s)) {
                stringList.add(s);
            }
        }

        return stringList.toArray(new String[stringList.size()]);
    }

    private void checkUncommon(String[] wordsA, Map<String, Boolean> wordAndUncommoned) {
        for (String s : wordsA) {
            if (wordAndUncommoned.containsKey(s)) {
                wordAndUncommoned.put(s, false);
                continue;
            }
            wordAndUncommoned.put(s, true);
        }
    }
}

public class UncommonWord {
    public static void main(String[] args) {
        String A = "this apple is sweet";
        String B = "this apple is sour";

        Solution solution = new Solution();
        for (String s : solution.uncommonFromSentences(A, B)) {
            System.out.println(s);
        }
    }
}
