package codingTest.c0d6nam6B202.p3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        int n = 0;
        int k = 0;
        int[] strength = null;
        int[][] intervals = null;

        int i = 0;
        while ((temp = br.readLine()) != null) {
            final String[] s = temp.split(" ");
            if (n == 0 && k == 0) {
                n = Integer.parseInt(s[0]);
                k = Integer.parseInt(s[1]);
                strength = new int[n];
                intervals = new int[k][2];
                continue;
            }

            if (strength[0] == 0) {
                for (int j = 0; j < n; j++) {
                    strength[j] = Integer.parseInt(s[j]);
                }
                continue;
            }

            for (int j = 0; j < k; j++) {
                intervals[i][0] = Integer.parseInt(s[0]);
                intervals[i][1] = Integer.parseInt(s[1]);
            }

            i++;
        }

        solution(n, k, strength, intervals);
    }

    private static void solution(int n, int k, int[] strength, int[][] intervals) {
        for (int[] interval : intervals) {
            int result = 0;
            final Map<Integer, Integer> strengthTimesMap = new HashMap<>();
            final int from = interval[0];
            final int to = interval[1];

            for (int i = from; i <= to; i++) {
                final int value = getValue(strength, i);
                if (strengthTimesMap.containsKey(value)) {
                    final Integer times = strengthTimesMap.get(value);
                    result += value * times;
                    strengthTimesMap.put(value, times + 1);
                } else {
                    result += value;
                    strengthTimesMap.put(value, 2);
                }
            }

            System.out.println(result);
        }
    }

    private static int getValue(int[] strength, int idx) {
        return strength[idx - 1];
    }
}
