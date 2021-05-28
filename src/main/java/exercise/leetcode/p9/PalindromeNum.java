package exercise.leetcode.p9;

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return (x == revertedNumber) || (x == revertedNumber / 10);
    }
}

public class PalindromeNum {
    public static void main(String[] args) {
        int num = 121;
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(num));
    }
}
