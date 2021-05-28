package exercise.programmers.sort.kthnumber;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] ints = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(ints);
            answer[i] = ints[commands[i][2] - 1];
        }

        return answer;
    }
}

public class KthNumber {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commnads = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        Solution solution = new Solution();
        for (int i : solution.solution(array, commnads)) {
            System.out.print(i + "\t");
        }
    }
}
