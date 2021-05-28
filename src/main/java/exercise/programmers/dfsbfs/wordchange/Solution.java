package exercise.programmers.dfsbfs.wordchange;


import java.util.LinkedList;
import java.util.List;

class Word {
    private String name;
    private List<Word> changeable;
    private boolean visited;

    public Word(String name) {
        this.name = name;
        changeable = new LinkedList<>();
        visited = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Word> getChangeable() {
        return changeable;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    //주어진 word가 변환될 수 있는 단어인지 확인
    boolean checkChangeable(Word word) {
        int countIncorrect = 0;
        for (int i = 0; i < name.length(); i++) {
            if (this.name.charAt(i) != word.getName().charAt(i)) {
                countIncorrect++;
            }
            if (countIncorrect > 1) {
                return false;
            }
        }
        return countIncorrect == 1;
    }

    void addChangeable(Word[] words) {
        for (Word word : words) {
            if (checkChangeable(word)) {
                changeable.add(word);
            }
        }
    }
}

class Graph {
    private Word[] words;
    private int result;
    private String target;

    public Graph(String begin, String target, String[] inputWord) {
        this.target = target;
        this.words = new Word[inputWord.length + 1]; //begin까지 담아야 해서 +1
        for (int i = 0; i < inputWord.length; i++) {
            words[i] = new Word(inputWord[i]);
        }
        words[words.length - 1] = new Word(begin);
        result = -1;
        this.setChangeble();
    }

    //모든 Word들의 변환 가능한 단어를 changeable에 설정
    void setChangeble() {
        for (Word word : words) {
            word.addChangeable(words);
        }
    }

    boolean checkTargetExist() {
        for (Word word : words) {
            if (word.getName().equals(target)) {
                return true;
            }
        }
        result = 0;
        return false;
    }

    void findShortestPath(Word word, int step) {
        if (word.isVisited()) {
            return;
        }
        if (word.getName().equals(target)) {
            if (result == -1) {
                result = step;
                return;
            }
            result = Math.min(step, result);
            return;
        }

        word.setVisited(true);
        for (Word w : word.getChangeable()) {
            findShortestPath(w, step + 1);
        }
        word.setVisited(false);
    }

    void findShortestPath(String begin) {
        for (Word word : words) {
            if (begin.equals(word.getName())) {
                findShortestPath(word, 0);
                break;
            }
        }
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}

public class Solution {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
//        String[] words = {"hot", "dot", "dog", "lot", "log"};

        Solution solution = new Solution();
        System.out.println(solution.solution(begin, target, words));
    }

    public int solution(String begin, String target, String[] words) {
        Graph graph = new Graph(begin, target, words);
        if (graph.checkTargetExist()) {
            graph.findShortestPath(begin);
        }
        return graph.getResult();
    }
}
