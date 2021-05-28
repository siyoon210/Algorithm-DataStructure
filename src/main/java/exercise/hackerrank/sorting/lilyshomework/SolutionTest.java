package exercise.hackerrank.sorting.lilyshomework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SolutionTest {
    public static int swapCount=0;
    public static int findPivot(int[] a) {
        int sum=0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        double average = (double) sum / (double) a.length;

        double minGap = Math.abs(average - (double)a[0]);
        int pivotIndex = 0;

        for (int i = 1; i < a.length; i++) {
            if (Math.abs(average - (double) a[i]) < minGap) {
                minGap = Math.abs(average - (double) a[i]);
                pivotIndex = i;
            }
        }

        System.out.println(pivotIndex);
        return pivotIndex;
    }
    public static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    public static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int pivot = a[findPivot(a)];

        do {
            while (a[pl] < pivot) pl++;
            while (a[pr] > pivot) pr--;

            if (pl <= pr) {
                swap(a, pl++, pr--);
                swapCount++;
            }

        } while (pl<=pr);

        if (left < pr) {
            quickSort(a,left,pr);
        }
        if (pl < right) {
            quickSort(a,pl,right);
        }
    }

    // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr) {

        quickSort(arr,0,arr.length-1);
        return swapCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
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
}
