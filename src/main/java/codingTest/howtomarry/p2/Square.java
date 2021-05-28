package codingTest.howtomarry.p2;

class Solution {
    private int[][] board;

    public int solution(int[][] board) {
        this.board = board;
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                answer = Math.max(answer, calcMaxSquareArea(i, j));
            }
        }
        return answer;
    }

    private int calcMaxSquareArea(int i, int j) { //해당 좌표를 기준으로 만드는 가장 큰 면적
        //해당 좌표를 기준으로 좌상, 좌, 상의 3개의 좌표의 값을 가져온다.
        int a = getValue(i - 1, j - 1);
        int b = getValue(i, j - 1);
        int c = getValue(i - 1, j);

        //세개의 값과 해당 좌표의 값이 모두 0이 아니라면, 세개의 값의 최소값의 루트를 씌우고 1을 더한 값의 제곱은 해당 좌표의 값이 된다.
        if (a != 0 && b != 0 && c != 0 && board[i][j] != 0) {
            int min = Math.min(a, Math.min(b, c));
            board[i][j] = (int) Math.pow(Math.sqrt(min) + 1,2);
        }

        return board[i][j];
    }

    private int getValue(int i, int j) {
        if (isValidCoordinate(i, j)) {
            return board[i][j];
        }

        return 0;
    }

    private boolean isValidCoordinate(int i, int j) {
        return (i >= 0) && (j >= 0);
    }
}

public class Square {
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 0}
        };

        Solution solution = new Solution();
        System.out.println(solution.solution(board));
    }
}