package exercise.hackerrank.sorting.lilyshomework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr) {
        int[] tmp = new int[arr.length];
        int max=0;

        for (int i = 0; i < arr.length; i++) {
            tmp[i] =1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && tmp[i] < tmp[j] + 1) {
                    tmp[i]++;
                }
                if (max < tmp[i]) {
                    max = tmp[i];
                }
            }
        }
        return arr.length-max;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
