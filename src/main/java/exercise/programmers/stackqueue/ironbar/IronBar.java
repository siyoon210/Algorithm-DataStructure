package exercise.programmers.stackqueue.ironbar;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        int barCount = 0;
        Queue<Character> queue = new LinkedList<>();

        for (char c : arrangement.toCharArray()) {
            queue.add(c);
        }


        while (!queue.isEmpty()) {
            if (queue.poll() == '(') {
                //레이저 발사
                if (!queue.isEmpty() && queue.peek() == ')') {
                    answer += barCount;
                    queue.poll();
                } else {
                    barCount++;
                }
            } else {
                barCount--;
                answer++;
            }
        }

        return answer;
    }
}

public class IronBar {
    public static void main(String[] args) {
        String arrangement = "()(((()())(())()))(())";

        Solution solution = new Solution();
        System.out.println(solution.solution(arrangement));
    }
}
