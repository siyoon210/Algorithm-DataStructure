package exercise.leetcode.p868;

class Solution {
    public int binaryGap(int N) {
        int answer = 0;
        int distance = 0;

        while (N > 0) {
            if (N % 2 != 0) {
                if (distance != 0) {
                    answer = Math.max(answer, distance);
                    distance = 1;
                } else {
                    distance++;
                }
            } else if(distance != 0) {
                distance++;
            }
            N /= 2;
        }

        return answer;
    }
}

public class BinaryGap {
    public static void main(String[] args) {
        int N = 22;

        Solution solution = new Solution();
        System.out.println(solution.binaryGap(N));
    }
}
