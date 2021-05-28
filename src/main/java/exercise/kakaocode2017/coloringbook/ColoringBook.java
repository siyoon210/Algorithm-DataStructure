package exercise.kakaocode2017.coloringbook;

class Solution {
    private int[][] picture;
    private boolean[][] cellCheckTable;
    private int m;
    private int n;

    static class AreaSize {
        int amount = 1;
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        this.m = m;
        this.n = n;
        this.picture = picture;
        cellCheckTable = new boolean[m][n];

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] == 0) {
                    continue;
                }

                if (cellCheckTable[i][j]) {
                    continue;
                }

                AreaSize size = new AreaSize();
                numberOfArea++;
                checkAdjacentDirection(i, j + 1, picture[i][j], size);
                checkAdjacentDirection(i + 1, j, picture[i][j], size);
                maxSizeOfOneArea = Math.max(size.amount, maxSizeOfOneArea);
            }
        }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private void checkAdjacentDirection(final int i, final int j, final int cellValue, AreaSize size) {
        if (i >= m || j >= n) {
            return;
        }

        if (cellCheckTable[i][j]) {
            return;
        }

        if (picture[i][j] == cellValue) {
            cellCheckTable[i][j] = true;
            size.amount++;
            checkAdjacentDirection(i, j + 1, picture[i][j], size);
            checkAdjacentDirection(i + 1, j, picture[i][j], size);
        }
    }
}

public class ColoringBook {
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };     // 4, 5

//        int m = 6;
//        int n = 4;
//        int[][] picture = {
//                {1, 1, 1, 0},
//                {1, 1, 1, 0},
//                {0, 0, 0, 1},
//                {0, 0, 0, 1},
//                {0, 0, 0, 1},
//                {0, 0, 0, 1}
//        }; //2, 6

        Solution solution = new Solution();
        for (final int i : solution.solution(m, n, picture)) {
            System.out.print(i + " ");
        }
    }
}
