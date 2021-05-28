package exercise.leetcode.p461;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
//    public int hammingDistance(int x, int y) {
//        int answer = 0;
//        String bitStr = Integer.toBinaryString(x ^ y);
//        for (char c : bitStr.toCharArray()) {
//            if (c == '1') {
//                answer++;
//            }
//        }
//
//        return answer;
//    }

    /**
     * 시간복잡도 O(n) : 비트의 수가 n이라면 n만큼 순회
     * 공간복잡도 O(1) : 상수만큼의 공간을 차지
     */
    public int hammingDistance(int x, int y) {
        int answer = 0;
        int temp = x ^ y;

        while (temp > 0) {
            answer += temp & 1;
            temp >>= 1;
        }

        return answer;
    }
}

public class HammingDistance {
    public static void main(String[] args) {
        int x = 1;
        int y = 4;

        Solution solution = new Solution();
        assertThat(solution.hammingDistance(x, y)).isEqualTo(2);
    }
}
