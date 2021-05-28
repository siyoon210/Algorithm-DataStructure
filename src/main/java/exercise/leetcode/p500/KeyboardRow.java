package exercise.leetcode.p500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] findWords(String[] words) {
        Map<Character, Integer> alphabetAndRow = setMap();
        List<String> answerList = new ArrayList<>();

        for (String word : words) {
            char[] chars = convertWordToUpcaseChars(word);
            checkWord(alphabetAndRow, answerList, word, chars);
        }

        String[] answer = new String[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }


        return answer;
    }

    private void checkWord(Map<Character, Integer> alphabetAndRow, List<String> answerList, String word, char[] chars) {
        if (checkWord(alphabetAndRow, chars)) {
            answerList.add(word);
        }
    }

    private char[] convertWordToUpcaseChars(String word) {
        return word.toUpperCase().toCharArray();
    }

    private boolean checkWord(Map<Character, Integer> alphabetAndRow, char[] chars) {
        int firstRow = alphabetAndRow.get(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (firstRow != alphabetAndRow.get(chars[i])) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> setMap() {
        Map<Character, Integer> alphabetAndRow = new HashMap<>();
        alphabetAndRow.put('Q', 1);
        alphabetAndRow.put('W', 1);
        alphabetAndRow.put('E', 1);
        alphabetAndRow.put('R', 1);
        alphabetAndRow.put('T', 1);
        alphabetAndRow.put('Y', 1);
        alphabetAndRow.put('U', 1);
        alphabetAndRow.put('I', 1);
        alphabetAndRow.put('O', 1);
        alphabetAndRow.put('P', 1);
        alphabetAndRow.put('A', 2);
        alphabetAndRow.put('S', 2);
        alphabetAndRow.put('D', 2);
        alphabetAndRow.put('F', 2);
        alphabetAndRow.put('G', 2);
        alphabetAndRow.put('H', 2);
        alphabetAndRow.put('J', 2);
        alphabetAndRow.put('K', 2);
        alphabetAndRow.put('L', 2);
        alphabetAndRow.put('Z', 3);
        alphabetAndRow.put('X', 3);
        alphabetAndRow.put('C', 3);
        alphabetAndRow.put('V', 3);
        alphabetAndRow.put('B', 3);
        alphabetAndRow.put('N', 3);
        alphabetAndRow.put('M', 3);

        return alphabetAndRow;
    }
}

public class KeyboardRow {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        for (String word : solution.findWords(words)) {
            System.out.println(word);
        }

    }
}
