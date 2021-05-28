package exercise.baekjoon.bruteforce.p1966;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//printer Q
class Document {
    private int sequence;
    private int importance;

    public Document(int sequence, int importance) {
        this.sequence = sequence;
        this.importance = importance;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        for (int i = 0; i < testcase; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] importance = new int[N];
            for (int j = 0; j < N; j++) {
                importance[j] = sc.nextInt();
            }
            System.out.println(solution(N, M, importance));
        }
    }

    public static int solution(int N, int M, int[] importance) {
        Queue<Document> documentQueue = new LinkedList<>();
        for (int i = 0; i < importance.length; i++) {
            documentQueue.add(new Document(i, importance[i]));
        }
        int result = 1;
        while (true) {
            //중요도가 높은 문서가 있다면 false 아니면 true
            if (checkImportance(documentQueue)) {
                if (documentQueue.poll().getSequence() == M) {
                    return result;
                } else {
                    result++;
                }
            }
        }
    }

    private static boolean checkImportance(Queue<Document> documentQueue) {
        for (int i = 1; i < documentQueue.size(); i++) {
            //픽한 문서가 다른 문서보다 중요도가 낮은 경우 마지막에 넣는다.
            if (documentQueue.peek().getImportance() < ((LinkedList<Document>) documentQueue).get(i).getImportance()) {
                documentQueue.add(documentQueue.poll());
                return false;
            }
        }
        return true;
    }
}
