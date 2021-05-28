package exercise.leetcode.p771;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Hash를 사용해도 시간복잡도는 같지만 해싱하는 작업이 필요하기 때문에 배열로 구현하는게 훨씬 빨랐다. (7ms -> 1ms)
 */
class Solution {
    public int numJewelsInStones(String J, String S) {
//        Set<Character> set = new HashSet<>();
//        int answer = 0;
//        for (char c : J.toCharArray()) {
//            set.add(c);
//        }
//        for (char c : S.toCharArray()) {
//            if (set.contains(c)) {
//                answer++;
//            }
//        }
//
//        return answer;

        int answer= 0;
        boolean[] charJ = new boolean[123];
        for (char c : J.toCharArray()) {
            charJ[c] = true;
        }

        for (char c : S.toCharArray()) {
            if (charJ[c]) {
                answer++;
            }
        }

        return answer;
    }
}

public class JewelsAndStones {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.numJewelsInStones("aA", "aAAbbbb")).isEqualTo(3);
        assertThat(solution.numJewelsInStones("z", "ZZ")).isEqualTo(0);
    }
}
