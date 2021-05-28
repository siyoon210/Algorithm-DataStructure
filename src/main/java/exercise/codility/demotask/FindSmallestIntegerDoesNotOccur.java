package exercise.codility.demotask;

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int answer = 1;
        while (true) {
            if (Arrays.binarySearch(A, answer) >= 0) {
                answer++;
            } else {
                return answer;
            }
        }
    }
}

public class FindSmallestIntegerDoesNotOccur {
    public static void main(String[] args) {
        int[] A = {-1, -2};

        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }
}
