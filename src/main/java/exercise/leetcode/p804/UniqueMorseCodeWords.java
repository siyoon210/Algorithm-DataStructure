package exercise.leetcode.p804;

import java.util.HashSet;
import java.util.Set;

class Solution {
    private final String[] morseCodeTable = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> transformations = new HashSet<>();
        for (String word : words) {
            transformations.add(convertToMorseCode(word));
        }

        return transformations.size();
    }

    private String convertToMorseCode(String word) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : word.toCharArray()) {
            stringBuilder.append(morseCodeTable[c - 'a']);
        }
        return stringBuilder.toString();
    }
}

public class UniqueMorseCodeWords {
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};

        Solution solution = new Solution();
        System.out.println(solution.uniqueMorseRepresentations(words));
    }
}
