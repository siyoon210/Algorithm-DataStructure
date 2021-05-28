package exercise.programmers.p12906;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answerList = new ArrayList<>();

        if (arr.length <= 0) {
            return arr;
        }

        answerList.add(arr[0]);
        int preNum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (preNum != arr[i]) {
                answerList.add(arr[i]);
                preNum = arr[i];
            }
        }

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}

public class 같은숫자는싫어 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        Solution solution = new Solution();
        Arrays.stream(solution.solution(arr)).forEach(System.out::println);
    }
}
