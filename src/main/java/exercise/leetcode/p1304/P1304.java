package exercise.leetcode.p1304;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int[] sumZero(int n) {
        int[] answer = new int[n];

        for (int i = 0; i < n - 1; i += 2) {
            answer[i] = i + 1;
            answer[i + 1] = -(i + 1);
        }

        return answer;
    }
}

public class P1304 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 5;
        int[] ints = solution.sumZero(n);
        assertThat(sumOfArray(ints)).isEqualTo(0);
        assertThat(ints.length).isEqualTo(n);

        n = 3;
        ints = solution.sumZero(n);
        assertThat(sumOfArray(ints)).isEqualTo(0);
        assertThat(ints.length).isEqualTo(n);

        n = 6;
        ints = solution.sumZero(n);
        assertThat(sumOfArray(ints)).isEqualTo(0);
        assertThat(ints.length).isEqualTo(n);
    }

    private static int sumOfArray(int[] ints) {
        int sum = 0;

        for (int i : ints) {
            sum += i;
        }

        return sum;
    }
}


