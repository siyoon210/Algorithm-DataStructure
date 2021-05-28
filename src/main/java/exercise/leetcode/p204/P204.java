package exercise.leetcode.p204;

import java.util.Arrays;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
                for (int j = 2; j * i < n; j++) {
                    isPrime[j * i] = false;
                }
            }
        }

        return count;
    }
}

/**
 * 소수찾기
 * 소수 2의 모든 배수는 소수가 아니다. 4, 6, 8, 10 ...
 * 소수 3의 모든 배수는 소수가 아니다. 3, 6, 9, 12, 15 ...
 * 소수 5의 모든 배수는 소수가 아니다. 10, 15, 20 ...
 * https://leetcode.com/problems/count-primes/discuss/57588/My-simple-Java-solution
 */

/**
 * - 성능을 더 올리기 위해서 isNotPrime으로 둔다면 fill하는 과정이 없어도 가능. 시간복잡도로 본다면 의미없음
 * - 시간복잡도가 O(N(logN)(logN)) 이라고 하나 이해가 안됨
 */

public class P204 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.countPrimes(10)).isEqualTo(4);
        assertThat(solution.countPrimes(2)).isEqualTo(0);

        out.println("p204" + " success!");
    }
}
