package exercise.leetcode.p344;

class Solution {
    public void reverseString(char[] s) {
        int length = s.length;
        char tmp;
        for (int i = 0; i < length / 2; i++) {
            tmp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = tmp;
        }
    }
}

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};

        Solution solution = new Solution();
        solution.reverseString(s);
    }
}
