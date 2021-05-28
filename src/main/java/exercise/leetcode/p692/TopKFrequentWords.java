package exercise.leetcode.p692;

import java.util.*;

class Solution {
    private class Word implements Comparable<Word>{
        private String str;
        private int count;

        Word(String str, int count) {
            this.str = str;
            this.count = count;
        }

        @Override
        public int compareTo(Word o) {
            int i = o.count - this.count;
            if (i == 0) {
                return str.compareTo(o.str);
            } else {
                return i;
            }
        }
    }

    List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String str : words) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }

        List<Word> list = new ArrayList<>();

        for (String s : map.keySet()) {
            list.add(new Word(s, map.get(s)));
        }

        Collections.sort(list);

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            answer.add(list.get(i).str);
        }

        return answer;
    }
}
public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;

        Solution solution = new Solution();
        for (String s : solution.topKFrequent(words, k)) {
            System.out.println(s);
        }
    }
}
