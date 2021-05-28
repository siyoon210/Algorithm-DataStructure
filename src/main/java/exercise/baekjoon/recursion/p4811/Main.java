package exercise.baekjoon.recursion.p4811;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    private static BigInteger result;

    public static void main(String[] args) {
        int countW = 0;
        int countH = 0;

        Scanner sc = new Scanner(System.in);
        while (true) {
            result = BigInteger.ZERO;
            int N = sc.nextInt();
            if (N == 0) {
                break;
            }
            solution(N, countW, countH, 0);
            System.out.println(result.toString());
        }

    }

    public static void solution(int N, int countW, int countH, int depth) {
        if (depth >= (2 * N)) {
            result = result.add(BigInteger.ONE);
            return;
        }

        //W가 나오는 경우
        //W는 N보다 작아야 한다.
        if (countW < N) {
            solution(N, countW + 1, countH, depth + 1);
        }

        //H가 나오는 경우
        //H는 W보다 작아야만 한다.
        if (countH < countW) {
            solution(N, countW, countH + 1, depth + 1);
        }
    }
}
