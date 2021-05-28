package exercise.baekjoon.linkedlist.p1158;

import java.util.Scanner;

public class Main { //조세퍼스 문제
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        solution(N,M);
    }

    public static void solution(int N, int M) {
        int[] arr = new int[N];
        int ptr = -1; //현재 보고있는 배열의 인덱스
        int moveCount = 0; //실제 이동을 M번 만큼 했는지
        int outputCount = 0; //몇번 출력을 진행했는지

        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }

        System.out.print("<");
        while (outputCount < N) {
            ptr++;
            if (ptr >= N) {
                ptr = 0;
            }

            if (arr[ptr] != 0) {
                moveCount++;
            }

            if (moveCount == M) {
                System.out.print(arr[ptr]);
                outputCount++;
                arr[ptr] = 0;
                moveCount = 0;

                if (outputCount < N) {
                    System.out.print(", ");
                }
            }
        }
        System.out.print(">");

    }
}
