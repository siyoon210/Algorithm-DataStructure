package codingTest.c0d6nam6B202.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        int arraySize = 0;
        int durability = 0;
        int[][] mineArray = null;
        int i = 0;
        while ((temp = br.readLine()) != null) {
            if (mineArray == null) {
                final String[] s = temp.split(" ");
                arraySize = Integer.parseInt(s[0]);
                durability = Integer.parseInt(s[1]);
                mineArray = new int[arraySize][arraySize];
                continue;
            }

            final String[] s = temp.split(" ");
            for (int j = 0; j < arraySize; j++) {
                mineArray[i][j] = Integer.parseInt(s[j]);
            }
            i++;
        }

        solution(durability, mineArray, arraySize);
    }

    private static void solution(int durability, int[][] mineArray, int arraySize) {
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (i == 0) {
                    mineArray[i][j] += mineArray[i][j - 1];
                    continue;
                }

                if (j == 0) {
                    mineArray[i][j] += mineArray[i - 1][j];
                    continue;
                }

                mineArray[i][j] += Math.min(mineArray[i][j - 1], mineArray[i - 1][j]);
            }
        }

        final int result = durability - mineArray[arraySize - 1][arraySize - 1];
        if ((result <= 0)) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
