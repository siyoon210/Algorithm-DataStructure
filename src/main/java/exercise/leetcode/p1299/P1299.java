package exercise.leetcode.p1299;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int[] replaceElements(int[] arr) {
        int greatest = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = greatest;
            greatest = Math.max(greatest, tmp);
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
}

public class P1299 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.replaceElements(new int[]{17, 18, 5, 4, 6, 1})).isEqualTo(new int[]{18, 6, 6, 6, 1, -1});

        out.println("p1299" + " success!");
    }
}
