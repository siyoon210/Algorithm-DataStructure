package codingTest.c0d6nam6B201.p1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer age = null;
        String temp;
        List<Integer> heartRates = new ArrayList<>();
        while ((temp = br.readLine()) != null) {
            if (age == null) {
                age = Integer.valueOf(temp);
                continue;
            }

            heartRates.add(Integer.valueOf(temp));
        }

        solution(age, heartRates);
    }

    private static void solution(Integer age, List<Integer> heartRates) {
        int 휴식 = 0;
        int 워밍업 = 0;
        int 집중훈련 = 0;
        int 중강도훈련 = 0;
        int 고강도훈련 = 0;
        int 최고강도훈련 = 0;

        Double maxHeartRate = 220.0 - age;

        for (Integer heartRate : heartRates) {
            final double percentBasedOnMaximumHeartRate = (heartRate / maxHeartRate) * 100;
            if (percentBasedOnMaximumHeartRate < 60) {
                휴식++;
                continue;
            }

            if (60 <= percentBasedOnMaximumHeartRate && percentBasedOnMaximumHeartRate < 68) {
                워밍업++;
                continue;
            }

            if (68 <= percentBasedOnMaximumHeartRate && percentBasedOnMaximumHeartRate < 75) {
                집중훈련++;
                continue;
            }

            if (75 <= percentBasedOnMaximumHeartRate && percentBasedOnMaximumHeartRate < 80) {
                중강도훈련++;
                continue;
            }

            if (80 <= percentBasedOnMaximumHeartRate && percentBasedOnMaximumHeartRate < 90) {
                고강도훈련++;
                continue;
            }

            최고강도훈련++;
        }


        System.out.println(최고강도훈련 + " " + 고강도훈련 + " " + 중강도훈련 + " " + 집중훈련 + " " + 워밍업 + " " + 휴식);
    }
}
