package exercise.baekjoon.etc.forbiddenzero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer input = sc.nextInt();
        System.out.println(solution(input));
    }

    private static Integer solution(Integer input) {
        input += 1;
        char[] chars = input.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                chars[i] = '1';
            }
        }

        return Integer.parseInt(String.valueOf(chars));
    }
}
