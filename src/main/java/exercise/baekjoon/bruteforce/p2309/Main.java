package exercise.baekjoon.bruteforce.p2309;

import java.util.Arrays;

public class Main { //일곱난쟁이
    public static void main(String[] args) {
        int[] inputArr = {20, 7, 23, 19, 10, 15, 25, 8, 13};
        findDwarf(inputArr);
    }

    public static void findDwarf(int[] arr) {
        Arrays.sort(arr); //배열의 요소들을 오름차순으로 정렬해둔다 (출력을 위함)

        for (int i = 0; arr.length - i >= 7; i++) {
            for (int j = i + 1; arr.length - j >= 6; j++) {
                for (int k = j + 1; arr.length - k >= 5; k++) {
                    for (int l = k + 1; arr.length - l >= 4; l++) {
                        for (int m = l + 1; arr.length - m >= 3; m++) {
                            for (int n = m + 1; arr.length - n >= 2; n++) {
                                for (int o = n + 1; arr.length - o >= 1; o++) {
                                    if ((arr[i] + arr[j] + arr[k] + arr[l] + arr[m] + arr[n] + arr[o])==100) {
                                        System.out.println(arr[i]);
                                        System.out.println(arr[j]);
                                        System.out.println(arr[k]);
                                        System.out.println(arr[l]);
                                        System.out.println(arr[m]);
                                        System.out.println(arr[n]);
                                        System.out.println(arr[o]);
                                        return;
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }

    }

}
