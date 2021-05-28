package exercise.programmers.stackqueue.printer;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

class Document {
    int index;
    int priority;

    public Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Document> documents = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            documents.add(new Document(i, priorities[i]));
        }

        while (!documents.isEmpty()) {
            Document poll = documents.poll();
            Optional<Document> first = documents.stream().filter(d -> d.getPriority() > poll.getPriority()).findFirst();
            if (first.isPresent()) {
                documents.add(poll);
                continue;
            }

            if (poll.getIndex() == location) {
                return answer;
            } else {
                answer++;
            }
        }

        return -1;
    }
}

public class Printer {
    public static void main(String[] args) {
//        int[] priorities = {2, 1, 3, 2};
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;

        Solution solution = new Solution();
        System.out.println(solution.solution(priorities, location));
    }
}
