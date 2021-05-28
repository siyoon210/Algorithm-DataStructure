package exercise.leetcode.p1012;

class Solution {
    public int bitwiseComplement(int N) {
        int n = 1;
        while (n < N) n = n *2 +1 ;
        return N ^ n;
    }
}

public class CompleOfBaseTenInt {
    public static void main(String[] args) {
        int N = 5;

        Solution solution = new Solution();
        System.out.println(solution.bitwiseComplement(5));
    }
}
