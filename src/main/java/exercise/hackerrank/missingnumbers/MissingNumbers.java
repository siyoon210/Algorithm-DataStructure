package exercise.hackerrank.missingnumbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    static int[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Integer> originNumberCounter = new HashMap<>();
        for (int number : brr) {
            originNumberCounter.put(number, originNumberCounter.getOrDefault(number, 0) + 1);
        }

        Map<Integer, Integer> missedNumberCounter = new HashMap<>();
        for (int number : arr) {
            missedNumberCounter.put(number, missedNumberCounter.getOrDefault(number, 0) + 1);
        }

        int[] missingNumbers = new int[brr.length - arr.length];
        int index = 0;

        for (Integer number : originNumberCounter.keySet()) {
            Integer missingFrequency = missedNumberCounter.getOrDefault(number, 0);
            Integer originFrequency = originNumberCounter.get(number);
            if (missingFrequency.equals(originFrequency)) {
                continue;
            }

            for (int i = 0; i < originFrequency - missingFrequency; i++) {
                missingNumbers[index] = number;
                index++;
            }
        }

        Arrays.sort(missingNumbers);
        return missingNumbers;
    }
}

public class MissingNumbers {
    public static void main(String[] args) {
        assertThat(Solution.missingNumbers(new int[]{203, 204, 205, 206, 207, 208, 203, 204, 205, 206}, new int[]{203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204}))
                .isEqualTo(new int[]{204, 205, 206});
        assertThat(Solution.missingNumbers(new int[]{11, 4, 11, 7, 13, 4, 12, 11, 10, 14}, new int[]{11, 4, 11, 7, 3, 7, 10, 13, 4, 8, 12, 11, 10, 14, 12}))
                .isEqualTo(new int[]{3, 7, 8, 10, 12});

        out.println("missingNumbers" + " success!");
    }
}
