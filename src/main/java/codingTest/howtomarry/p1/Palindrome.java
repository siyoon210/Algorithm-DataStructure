package codingTest.howtomarry.p1;

public class Palindrome {
    public static void main(String[] args) {
        Solution test = new Solution();

        System.out.println(test.solution(1, 100)); //18
        System.out.println(test.solution(100, 300)); // 20
        System.out.println(test.solution(100, 1)); // 0
        System.out.println(test.solution(20, 22)); // 1
        System.out.println(test.solution(0, 9)); // 10
        System.out.println(test.solution(0, 1_000_000)); // 0 if처리 안해주면 1999개고 일치함.
    }
}

class Solution {
    public int solution(int n, int m) {
        if (n > m || m > 500_000)
            return 0;

        int answer = 0;

        for (int num = n; num <= m; num++) {
            if (isPalindrome(num))
                answer++;
        }
        return answer;
    }

    private boolean isPalindrome(int num) {
        if (num < 0 || (num != 0 && num % 10 == 0)) return false;

        int reverseNum = 0;
        while (num > reverseNum) {
            reverseNum = reverseNum * 10 + num % 10;
            num = num / 10;
        }
        return (num == reverseNum || num == reverseNum / 10);
    }
}

