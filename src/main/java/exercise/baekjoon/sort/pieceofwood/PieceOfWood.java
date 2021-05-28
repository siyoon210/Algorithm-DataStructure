package exercise.baekjoon.sort.pieceofwood;

import java.util.Scanner;

public class PieceOfWood {
    public static void swapElement(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {

            for (int j = 0; j < a.length-1; j++) {
                boolean swap =false;
                if (a[j] > a[j+1]) {
                    swapElement(a,j,j+1);
                    swap =true;
                }
                if (swap) {
                    for (int e : a) {
                        System.out.print(e+" ");
                    }
                    System.out.println();
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];
        for (int i = 0; i < a.length; i++) {
            System.out.print(i+"번쨰 인덱스 : ");
            a[i]=sc.nextInt();
        }
        bubbleSort(a);
    }
}
