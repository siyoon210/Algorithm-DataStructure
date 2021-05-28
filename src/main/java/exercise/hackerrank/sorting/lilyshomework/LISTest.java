package exercise.hackerrank.sorting.lilyshomework;

import java.util.Scanner;

public class LISTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), max = 0;
        int a[] = new int[n], d[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            d[i] =1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && d[i] < d[j] + 1) {
                    d[i]++;
                }
                if (max < d[i]) {
                    max = d[i];
                }
            }
        }
        System.out.println(n - max);
        sc.close();

}
}
