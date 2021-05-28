package exercise.leetcode.p476;

class Solution {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        long answer = num ^ (long) Math.pow(2, s.length()) - 1;
        return (int) answer;
    }
}

public class NumberComplement {
    public static void main(String[] args) {
        int num = 2147483647;

        Solution solution = new Solution();
        System.out.println(solution.findComplement(num));
    }
}
