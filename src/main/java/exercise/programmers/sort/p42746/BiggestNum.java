package exercise.programmers.sort.p42746;

import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] strings = new String[numbers.length];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strings, (num1, num2) -> ((num2 + num1).compareTo(num1 + num2)));

        StringBuffer sb = new StringBuffer();

        for (String string : strings) {
            sb.append(string);
        }

        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }
}

public class BiggestNum {
    public static void main(String[] args) {
//        int[] numbers = {0, 0, 0, 10};
//        int[] numbers = {12, 121};
//        int[] numbers = {5, 546};
        int[] numbers = {0, 0, 0};

        Solution solution = new Solution();
        System.out.println(solution.solution(numbers));
    }
}
