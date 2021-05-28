package exercise.leetcode.p70;

import static org.assertj.core.api.Assertions.assertThat;

//70. Climbing Stairs
class Solution {
    /**
     * 일반적인 피보나치 풀이법
     * 시간복잡도 O(n), 공간복잡도 O(1)
     */
//    public int climbStairs(int n) {
//        int i1 = 1, i2 = 2;
//
//        if (n == 1) return i1;
//        if (n == 2) return i2;
//
//        int tmp = 0;
//        for (int i = 2; i < n; i++) {
//            tmp = i2;
//            i2 = i1 + i2;
//            i1 = tmp;
//        }
//
//        return i2;
//    }

    /**
     * 다이나믹 프로그래밍
     * 시간복잡도 O(n), 공간복잡도 O(n)
     */
    public int climbStairs(int n) {
        int[] d = new int[n + 1];
        d[1] = 1;
        if(n == 1) return d[1];
        d[2] = 2;
        if(n == 2) return d[2];

        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        return d[n];
    }
}

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.climbStairs(1)).isEqualTo(1);
        assertThat(solution.climbStairs(2)).isEqualTo(2);
        assertThat(solution.climbStairs(3)).isEqualTo(3);
        assertThat(solution.climbStairs(4)).isEqualTo(5);
        assertThat(solution.climbStairs(5)).isEqualTo(8);
        assertThat(solution.climbStairs(6)).isEqualTo(13);
    }
}
