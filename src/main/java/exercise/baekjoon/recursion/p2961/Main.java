package exercise.baekjoon.recursion.p2961;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static exercise.baekjoon.recursion.p2961.BitTest.input;

class Ingredient {
    private int sin;
    private int sseun;

    public Ingredient(int sin, int sseun) {
        this.sin = sin;
        this.sseun = sseun;
    }

    public int getSin() {
        return sin;
    }

    public void setSin(int sin) {
        this.sin = sin;
    }

    public int getSseun() {
        return sseun;
    }

    public void setSseun(int sseun) {
        this.sseun = sseun;
    }
}

public class Main {
    private static int result=-1;

    public static void main(String[] args) {

        List<Ingredient> list = new ArrayList<>();
        input(list);
//        list.add(new Ingredient(1, 7));
//        list.add(new Ingredient(2, 6));
//        list.add(new Ingredient(3, 8));
//        list.add(new Ingredient(4, 9));
        int[] flag = new int[list.size()];
        solution(list, 0, 1, 0, flag);
        System.out.println(result);
    }

    public static void solution(List<Ingredient> list, int depth, int sin, int sseun, int[] flag) {
        if (depth >= list.size()) {
            int tmpsum = 0;
            for (int i = 0; i < flag.length; i++) {
                tmpsum += flag[i];
            }
            if (tmpsum == 0) {
                return;
            }

            for (int i = 0; i < flag.length; i++) {
                if (flag[i] == 1) {
                    sin *= list.get(i).getSin();
                    sseun += list.get(i).getSseun();
                }
            }
//            System.out.println("flag: "+flag[0]+flag[1]+flag[2]+flag[3]);
            int i = Math.abs(sin - sseun); //차이
//            System.out.println(i);
            if (result == -1) {
                result = i;
            }
            if (result > i) {
                result = i;
            }
            return;
        }

        //염두 안하는 경우
        flag[depth] = 0;
        solution(list, depth+1, sin, sseun, flag);

        //염두 하는 경우
        flag[depth] = 1;
        solution(list, depth+1, sin, sseun, flag);
    }
}

