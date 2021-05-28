package exercise.codility.lesson3.frogjmp;

class Solution {
    public int solution(int X, int Y, int D) {
        return (int) Math.ceil((Y - X) / (double) D);
    }
}

public class FrogJmp {
    public static void main(String[] args) {
        int X = 10;
        int Y = 85;
        int D = 30;

        Solution solution = new Solution();
        System.out.println(solution.solution(X, Y, D));
    }
}
