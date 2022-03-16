package exercise.baekjoon.p10952;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            String[] strings = input.split(" ");
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[1]);

            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(a+b);
        }
    }
}
