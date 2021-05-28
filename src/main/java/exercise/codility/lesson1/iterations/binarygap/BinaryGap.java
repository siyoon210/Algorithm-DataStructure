package exercise.codility.lesson1.iterations.binarygap;

class Solution {
    public int solution(int N) {
        boolean flag = false;
        int longestGap = 0;
        int tmpGap = 0;
        int bit = 0;

        while (N > 0) {
            bit = N % 2;
            N /= 2;
            if (!flag && bit == 1) {
                flag = true;
                continue;
            }
            if (flag && bit == 0) {
                tmpGap++;
            } else if (flag) {
                longestGap = Math.max(longestGap, tmpGap);
                tmpGap = 0;
            }
        }

        return longestGap;
    }
}

public class BinaryGap {
    public static void main(String[] args) {
        int N = 1041;

        Solution solution = new Solution();
        System.out.println(solution.solution(N));
    }
}
