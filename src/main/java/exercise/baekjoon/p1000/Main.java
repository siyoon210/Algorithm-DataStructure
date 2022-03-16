package exercise.baekjoon.p1000;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String next = scanner.nextLine();
            String[] split = next.split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            solution(a, b);
        }
    }

    private static void solution(int a, int b) {
        System.out.println(a + b);
    }
}
