package exercise.leetcode.p338;

import java.util.Arrays;

class Solution {
    public int[] countBits(int num) {
        int[] answer = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            answer[i] = calcBitCount(i);
        }

        return answer;
    }

    private int calcBitCount(int num) {
        int count = 0;

        while (num > 0) {
            if (num % 2 == 1) {
                count++;
            }

            num /= 2;
        }

        return count;
    }
}

public class CountingBits {
    public static void main(String[] args) {
        int num = 5;

        Solution solution = new Solution();
        Arrays.stream(solution.countBits(num)).forEach(System.out::println);
    }
}
