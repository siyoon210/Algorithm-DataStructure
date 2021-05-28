package exercise.leetcode.p287;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }

        throw new IllegalArgumentException();
    }
}

/**
 * 공간복잡도가 O(1)을 만족해야하고, 시간복잡도는 O(n^2)까지 허용된다.
 * Two Pointer를 사용하면, 공간복잡도 O(1)을 만족한다.
 * 그렇다면 시간복잡도는?
 * 맨 처음 포인터는 (n-1)번 탐색해야한다. 그 다음 포인터는 (n-2)번 탐색해야한다.
 * 이런식으로 마지막 포인터는 1번만 탐색한다면,
 * 
 * 결국 1+2+3+..+n 번 탐색하는 것이다. 등차수열의 합은 (n+1)이 (n/2)개 있는 것이니, 시간복잡도 O(n^2)를 만족한다.
 */
public class P287 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.findDuplicate(new int[]{1, 3, 4, 2, 2})).isEqualTo(2);
        assertThat(solution.findDuplicate(new int[]{3, 1, 3, 4, 2})).isEqualTo(3);

        out.println("p287" + " success!");
    }
}
