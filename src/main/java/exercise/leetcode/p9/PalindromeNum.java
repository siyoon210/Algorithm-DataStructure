package exercise.leetcode.p9;

class Solution {
    public boolean isPalindrome(int x) {
        // 1. 주어진 정수를 문자열로 바꾼다.
        // 2. 맨 첨 문자와 맨 끝 문자를 비교한다.
        // 3. 한칸씩 가운데로 땡긴다 (문자의 가운데를 지나칠때까지)
        // 4. 만약 비교 문자가 다르면 false, 모두 같으면 true를 반환한다.

        String inputString = String.valueOf(x);

        int point1 = 0;
        int point2 = inputString.length() - 1; // ex) 0김 1예 2진 (길이는 3이다.)
        while (point1 < point2) {
            if (inputString.charAt(point1) != inputString.charAt(point2)) {
                return false;
            }
            point1++;
            point2--;
        }

        return true;


//        if(x < 0 || (x % 10 == 0 && x != 0)) {
//            return false;
//        }
//
//        int revertedNumber = 0;
//        while(x > revertedNumber) {
//            revertedNumber = revertedNumber * 10 + x % 10;
//            x /= 10;
//        }
//
//        return (x == revertedNumber) || (x == revertedNumber / 10);
    }
}

public class PalindromeNum {
    public static void main(String[] args) {
        int num = 121;
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(num));
    }
}
