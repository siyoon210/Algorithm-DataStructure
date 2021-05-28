package exercise.programmers.exaustivesearch.mocktest;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] answer = {1, 2, 3, 4, 5};

        for (int i : solution(answer)) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] answers) {
        int[] supoja1 = {1, 2, 3, 4, 5};
        int[] supoja2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoja3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        int[] index = new int[3];

        for (int i = 0; i < answers.length; i++) {
            index[0] = i % 5;
            index[1] = i % 8;
            index[2] = i % 10;

            if (supoja1[index[0]] == answers[i]) score[0]++;
            if (supoja2[index[1]] == answers[i]) score[1]++;
            if (supoja3[index[2]] == answers[i]) score[2]++;
        }

        List result = new ArrayList();
        int max = Math.max(score[0], Math.max(score[1], score[2]));

        for (int i = 0; i < 3; i++) {
            if (score[i] == max) {
                result.add(i + 1);
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.parseInt(result.get(i).toString());
        }

        return ans;
    }
}
