package exercise.leetcode.p2114;

class Solution {
    public int mostWordsFound(String[] sentences) {
        int answer = 0;
        for (String sentence : sentences) {
            String[] words = sentence.split(" ");
            int numberOfWords = words.length;
            answer = Math.max(answer, numberOfWords);
        }
        return answer;
    }
}
