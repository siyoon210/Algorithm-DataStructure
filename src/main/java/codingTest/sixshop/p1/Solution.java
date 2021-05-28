package codingTest.sixshop.p1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Result {
    public static String isPangram(List<String> strings) {
        Set<Character> alphabets;
        StringBuilder answer = new StringBuilder();

        for (String string : strings) {
            alphabets = new HashSet<>();
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (c != ' ') {
                    alphabets.add(c);
                }
                if (alphabets.size() >= 26) {
                    break;
                }
            }

            if (alphabets.size() == 26) {
                answer.append("1");
            } else {
                answer.append("0");
            }
        }
        return answer.toString();
    }
}

public class Solution {
        public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("we promptly judge antique ivory buckles for the next prize");
        stringList.add("we promptly judge antique ivory buckles for the prize");
        stringList.add("the quick brown fox jumps over the lazy dog");
        stringList.add("the quick brown fox jump over the lazy dog");
        //1010

        System.out.println(Result.isPangram(stringList));
    }
}