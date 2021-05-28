package exercise.baekjoon.recursion.p1074;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(solution(N, r, c));
    }

    static int solution(int N, int r, int c) {
        int result = 0;
        // 종료조건
        if (N == 0) {
            return result;
        }
        //가운데 기준점 찾아내기
        int midPoint = (int) ((Math.pow(2, N) / 2) - 1);

        //Z를 기준으로 0,1,2,3 중 어디에 위치한건지 찾아내기
        int position;
        if (r <= midPoint && c <= midPoint) {
            position = 0;
        } else if (r <= midPoint) {
            position = 1;
        } else if (c <= midPoint) {
            position = 2;
        } else {
            position = 3;
        }

        //위치(position)을 기준으로 앞에 몇칸이 존재하는지 계산하고 result에 더한다.
        result += position * ((int) Math.pow(Math.pow(2, N - 1), 2));

        //좌표를 조정한다. (맨 처음칸이 0,0이 되도록)
        switch (position) {
            case 1:
                c = (c - (midPoint + 1));
                break;
            case 2:
                r = (r - (midPoint + 1));
                break;
            case 3:
                r = (r - (midPoint + 1));
                c = (c - (midPoint + 1));
                break;
        }

        //종료조건에 수렴하도록 N을 1씩 뺀다.
        N--;

        //재귀적으로 result값을 구한다.
        result += solution(N, r, c);

        return result;
    }
}
