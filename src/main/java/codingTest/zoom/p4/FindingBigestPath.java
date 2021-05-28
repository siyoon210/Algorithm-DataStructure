package codingTest.zoom.p4;

class Solution {
    int biggestPath = 0;
    int[][] Board;
    boolean[][] marked;

    public int solution(int[][] Board) {
        this.Board = Board;
        this.marked = new boolean[Board.length][Board[0].length];

        for (int i = 0; i < Board.length; i++) {
            for (int j = 0; j < Board[i].length; j++) {
                findBiggestPath(i, j, new StringBuffer());
            }
        }

        return biggestPath;
    }

    private void findBiggestPath(int coordinateY, int coordinateX, StringBuffer path) {
        boolean flag;
        try {
            flag = marked[coordinateY][coordinateX];
        } catch (Exception e) {
            return;
        }

        if (!flag) {
            path.append(Board[coordinateY][coordinateX]);
        } else {
            return;
        }

        if (path.toString().length() >= 4) {
            biggestPath = Math.max(biggestPath, Integer.parseInt(path.toString()));
            path.delete(path.toString().length() - 1, path.toString().length());
            return;
        }

        marked[coordinateY][coordinateX] = true;

        findBiggestPath(coordinateY + 1, coordinateX, path);
        findBiggestPath(coordinateY, coordinateX + 1, path);
        findBiggestPath(coordinateY - 1, coordinateX, path);
        findBiggestPath(coordinateY, coordinateX - 1, path);

        path.delete(path.toString().length() - 1, path.toString().length());
        marked[coordinateY][coordinateX] = false;
    }
}

public class FindingBigestPath {
    public static void main(String[] args) {
//        int[][] Board = {
//                {9, 1, 1, 0, 7},
//                {1, 0, 2, 1, 0},
//                {1, 9, 1, 1, 0}
//        };

//        int[][] Board = {
//                {1,1,1},
//                {1,3,4},
//                {1,4,3}
//        };

        int[][] Board = {
                {0, 1, 5, 0, 0}
        };

        Solution solution = new Solution();
        System.out.println(solution.solution(Board));
    }
}
