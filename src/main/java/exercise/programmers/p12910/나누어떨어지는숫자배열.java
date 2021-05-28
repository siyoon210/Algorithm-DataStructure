package exercise.programmers.p12910;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        arr = Arrays.stream(arr).filter(num -> num % divisor == 0).sorted().toArray();
        return arr.length == 0 ? new int[]{-1} : arr;
    }
}

public class 나누어떨어지는숫자배열 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 15, 10};
        int divisor = 5;

        Solution solution = new Solution();
        Arrays.stream(solution.solution(arr, divisor)).forEach(System.out::println);
    }
}
