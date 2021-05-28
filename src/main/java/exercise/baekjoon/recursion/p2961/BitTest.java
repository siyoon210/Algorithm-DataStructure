package exercise.baekjoon.recursion.p2961;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BitTest {
    public static void main(String[] args) {
        List<Ingredient> list = new ArrayList<>();
        input(list);
//        list.add(new Ingredient(1, 7));
//        list.add(new Ingredient(2, 6));
//        list.add(new Ingredient(3, 8));
//        list.add(new Ingredient(4, 9));

        solutionByBinary(list, 0);
    }

    static void input(List<Ingredient> list) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String ingredient = sc.nextLine();
            String[] s = ingredient.split(" ");
            list.add(new Ingredient(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }
    }

    public static void solutionByBinary(List<Ingredient> list, int bit) {
        System.out.println(String.format("%0" + list.size() + "d", Integer.parseInt(Integer.toBinaryString(bit))));
        if (bit != 0) {

        }
    }
}
