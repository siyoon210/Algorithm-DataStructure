package exercise.leetcode.p657;

class Solution {
    public boolean judgeCircle(String moves) {
        int[] coordinate = new int[2];

        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    coordinate[0]++;
                    break;
                case 'D':
                    coordinate[0]--;
                    break;
                case 'L':
                    coordinate[1]--;
                    break;
                case 'R':
                    coordinate[1]++;
                    break;
            }
        }

        return coordinate[0] == 0 && coordinate[1] == 0;
    }
}

public class RobotReturnToOrigin {
    public static void main(String[] args) {
        String moves = "LL";

        Solution solution = new Solution();
        System.out.println(solution.judgeCircle(moves));
    }
}
