package exercise.baekjoon.sort.sortnumber2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i]=sc.nextInt();
        }

        quickSort(a, 0, N - 1);

        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl + pr) / 2];

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;

            if (pl <= pr) {
                swap(a, pl++, pr--);
            }

        } while (pl<=pr);

        if (left < pr) {
            quickSort(a,left,pr);
        }
        if (pl < right) {
            quickSort(a,pl,right);
        }
    }

    public static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }
}
