package exercise.leetcode.p1470;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int length = nums.length;
        int[] answer = new int[length];
        int pointerX = 0;
        int pointerY = n;
        int index = 0;

        while (pointerY < length) {
            answer[index] = nums[pointerX];
            answer[++index] = nums[pointerY];
            pointerX++;
            pointerY++;
            index++;
        }

        return answer;
    }
}

public class P1470 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)).isEqualTo(new int[]{2, 3, 5, 4, 1, 7});

        out.println("p1470" + " success!");
    }
}
