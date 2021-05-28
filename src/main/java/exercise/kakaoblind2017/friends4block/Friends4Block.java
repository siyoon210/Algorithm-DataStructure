package exercise.kakaoblind2017.friends4block;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    static class Columm {
        List<Block> blocks = new LinkedList<>();
    }

    static class Block {
        char charValue;
        boolean breakable;

        Block(final char charValue) {
            this.charValue = charValue;
            this.breakable = false;
        }
    }

    private int answer = 0;

    public int solution(int m, int n, String[] board) {
        List<Columm> rows = new ArrayList<>(n);

        setRows(m, n, board, rows);

        int preAnswer = -1;
        while (preAnswer != answer) {
            preAnswer = answer;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m - 1; j++) {
                    checkAndMarkAdjacentBlocksAreSame(rows, i, j);
                }
            }

            for (int i = 0; i < n; i++) {
                final Columm columm = rows.get(i);

                for (int size = columm.blocks.size() - 1; size >= 0; size--) {
                    if (columm.blocks.get(size).breakable) {
                        columm.blocks.remove(size);
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    private void setRows(final int m, final int n, final String[] board, final List<Columm> rows) {
        for (int i = 0; i < n; i++) {
            rows.add(new Columm());
        }

        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                rows.get(i).blocks.add(new Block(board[j].charAt(i)));
            }
        }
    }

    private void checkAndMarkAdjacentBlocksAreSame(final List<Columm> rows, final int i, final int j) {
        try {
            if (rows.get(i).blocks.get(j).charValue == rows.get(i + 1).blocks.get(j).charValue
                    && rows.get(i).blocks.get(j).charValue == rows.get(i).blocks.get(j + 1).charValue
                    && rows.get(i).blocks.get(j).charValue == rows.get(i + 1).blocks.get(j + 1).charValue) {


                rows.get(i).blocks.get(j).breakable = true;
                rows.get(i + 1).blocks.get(j).breakable = true;
                rows.get(i).blocks.get(j + 1).breakable = true;
                rows.get(i + 1).blocks.get(j + 1).breakable = true;
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

}

public class Friends4Block {
    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[] board = {
                "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        Solution solution = new Solution();
        System.out.println("solution.solution(m, n, board) = " + solution.solution(m, n, board));
    }
}
