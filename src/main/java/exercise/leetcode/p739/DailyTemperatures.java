package exercise.leetcode.p739;

import java.util.Arrays;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int[] dailyTemperatures(int[] T) {
//        int[] answer = new int[T.length];
//        Stack<Integer> idxStack = new Stack<>();
//
//        for (int i = T.length - 1; i >= 0; i--) {
//            while (!idxStack.empty() && T[i] >= T[idxStack.peek()]) {
//                idxStack.pop();
//            }
//
//            if (idxStack.empty()) {
//                answer[i] = 0;
//            } else {
//                answer[i] = idxStack.peek() - i;
//            }
//            idxStack.push(i);
//        }
//
//        return answer;

        /**
         * 1) 스택이 비어있다면, 순회하는 현재 값을 push
         * 스택이 비어있지 않다면,
         *      순회하는 현재 값과 peek한 값을 대조하고
         *      3) peek한 값이 더 작다면 peek한 값의 인덱스에 현재 값의 인덱스를 적어둔다. 그리고 peek한걸 pop하고 현재 값을 push
         *          이 과정은 스택이 비거나 혹은 peek한 값이 같거나 더클떄까지 반복
         *      4) peek한 값이 더 크다면 현재 값을 push
         *      5) 마지막으로 적어둔 인덱스에서, 위치 인덱스를 빼준다. 만약 0보다 값이 작다면 0으로 보정한다.
         */

        /**
         * 숫자들이 푸쉬되는 횟수는 각 1회로 n, 숫자들이 팝되는 횟수는 각 1회로 n
         * 즉, 시간복잡도는 2n -> O(n), 공간복잡도 O(n)
         */

        int[] answer = new int[T.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }


        return answer;
    }
}

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};

        Solution solution = new Solution();
        Arrays.stream(solution.dailyTemperatures(T)).forEach(System.out::println);
        assertThat(solution.dailyTemperatures(T)).isEqualTo(new int[]{1, 1, 4, 2, 1, 1, 0, 0});
    }
}
