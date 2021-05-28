package codingTest.programmers.remotejobpair201902.p1;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int answer;
    private List<Integer> primes;
    private int n;

    public int solution(int n) {
        this.answer = 0;
        this.primes = new ArrayList<>();
        this.n = n;
        List<Integer> flags = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        for (Integer prime : primes) {
            System.out.print(prime+", ");
        }
        System.out.println();

        clacCases(flags, 0);

        return answer;
    }

    private boolean isPrime(int num) {
        boolean isPrime = true;
        int temp;

        for (int i = 2; i <= num / 2; i++) {
            temp = num % i;
            if (temp == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

    private void clacCases(List<Integer> flag, int index) {
        //종료조건 (기저사례)
        if (index >= primes.size()) {
            return;
        }

        if (flag.size() == 3) {
            int sum = primes.get(flag.get(0)) + primes.get(flag.get(1)) + primes.get(flag.get(2));
            System.out.println(flag.get(0)+","+flag.get(1)+","+flag.get(2));

            flag.clear();

//            System.out.println("합산: "+ sum);
            if (sum == this.n) {
                answer++;
            }
            return;
        }

        //포함을 시키는 경우
        flag.add(index);
        clacCases(flag, index + 1);

        //포함을 시키지 않는 경우
        clacCases(flag, index + 1);
    }
}

public class PrimeNumber {
    public static void main(String[] args) {
        int n = 33;

        Solution solution = new Solution();
        System.out.println(solution.solution(n));
    }
}
