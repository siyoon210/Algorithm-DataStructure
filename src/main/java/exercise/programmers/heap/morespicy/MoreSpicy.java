package exercise.programmers.heap.morespicy;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i : scoville) {
            priorityQueue.add(i);
        }

        while (!priorityQueue.isEmpty() && priorityQueue.peek() < K){
            Integer lessSpicy = priorityQueue.poll();
            if (!priorityQueue.isEmpty()) {
                Integer secondLessSpicy = priorityQueue.poll();
                priorityQueue.add(lessSpicy + secondLessSpicy * 2);
                answer++;
            } else {
                return -1;
            }
        }
        return answer;
    }
}

public class MoreSpicy {
    public static void main(String[] args) {
        int[] scoville = {0, 0, 1};
        int K = 5;

        Solution solution = new Solution();
        System.out.println(solution.solution(scoville, K));
    }
}
