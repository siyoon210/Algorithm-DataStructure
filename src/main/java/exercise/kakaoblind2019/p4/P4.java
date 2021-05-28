package exercise.kakaoblind2019.p4;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int similarWordCount = 0;
            final List<Integer> wildCardIndices = getWildCardIndices(queries[i]);
            final Integer wildCardStartIndex = wildCardIndices.get(0);
            final Integer wildCardEndIndex = wildCardIndices.get(wildCardIndices.size() - 1);

            final String querySubStr;

            if (wildCardStartIndex == 0) {
                querySubStr = queries[i].substring(wildCardEndIndex + 1);
            } else {
                querySubStr = queries[i].substring(0, wildCardStartIndex);
            }

            for (final String word : words) {
                if (queries[i].length() != word.length()) {
                    continue;
                }

                final String wordSubStr;

                if (wildCardStartIndex == 0) {
                    wordSubStr = word.substring(wildCardEndIndex + 1);
                } else {
                    wordSubStr = word.substring(0, wildCardStartIndex);
                }

                if (querySubStr.equals(wordSubStr)) {
                    similarWordCount++;
                }
            }

            answer[i] = similarWordCount;
        }


        return answer;
    }

    private List<Integer> getWildCardIndices(final String query) {
        List<Integer> wildCardIndices = new ArrayList<>();

        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) == '?') {
                wildCardIndices.add(i);
            }
        }
        return wildCardIndices;
    }
}

public class P4 {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        Solution solution = new Solution();
        for (final int i : solution.solution(words, queries)) {
            System.out.println(i);
        }
    }
}
