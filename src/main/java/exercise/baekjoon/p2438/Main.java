package exercise.baekjoon.p2438;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String next = scanner.nextLine();
            String[] split = next.split(" ");
            int n = Integer.parseInt(split[0]);
            solution(n);
        }
    }

    private static void solution(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
