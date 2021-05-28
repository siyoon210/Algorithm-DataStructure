package exercise.leetcode.p819;

import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = extractWords(paragraph);

        Map<String, Integer> wordAndCount = calcWordCount(banned, words);

        return extractAnswer(wordAndCount);
    }

    private String extractAnswer(Map<String, Integer> wordAndCount) {
        int maxCount = 0;
        String answer = null;

        for (String s : wordAndCount.keySet()) {
            if (wordAndCount.get(s) > maxCount) {
                maxCount = wordAndCount.get(s);
                answer = s;
            }
        }
        return answer;
    }

    private Map<String, Integer> calcWordCount(String[] banned, String[] words) {
        Map<String, Integer> wordAndCount = new HashMap<>();
        Set<String> bans = new HashSet<>();
        Collections.addAll(bans, banned);
        bans.add(" ");

        for (String word : words) {
            if (bans.contains(word)) {
                continue;
            }

            if (wordAndCount.containsKey(word)) {
                wordAndCount.put(word, wordAndCount.get(word) + 1);
                continue;
            }

            wordAndCount.put(word, 1);
        }
        return wordAndCount;
    }

    private String[] extractWords(String paragraph) {
        String[] words = paragraph.replaceAll(",", " ").split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = convertLowerCase(words[i]);
            words[i] = removePunctuation(words[i]);
        }
        return words;
    }

    private String convertLowerCase(String word) {
        return word.toLowerCase();
    }

    private String removePunctuation(String word) {
        if (word.length() <= 0) {
            return " ";
        }

        int lastIndex = word.length() - 1;
        char lastChar = word.charAt(lastIndex);

        if ((lastChar < 'a') || (lastChar > 'z')) {
            word = word.substring(0, lastIndex);
        }

        return word;
    }
}

public class MostCommonWord {
    public static void main(String[] args) {
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};

        Solution solution = new Solution();
        System.out.println(solution.mostCommonWord(paragraph, banned));
    }
}
