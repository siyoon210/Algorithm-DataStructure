package exercise.programmers.p12912;

class Solution {
    public long solution(int a, int b) {
        if (a == b) {
            return a;
        }

        int bigNum = Math.max(a, b);
        int smallNum = Math.min(a, b);

        long answer = 0;

        while (smallNum <= bigNum) {
            answer += smallNum;
            smallNum++;
        }

        return answer;
    }
}

public class 두정수사이의합 {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;

        Solution solution = new Solution();
        System.out.println(solution.solution(a, b));
    }
}
