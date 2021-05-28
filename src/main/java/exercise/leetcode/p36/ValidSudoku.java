package exercise.leetcode.p36;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.filter;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //한 행씩 검사
        for (int i = 0; i < board.length; i++) {
            Set<Character> numCharSet = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (hasDuplicateChar(numCharSet, board[i][j])) {
                    return false;
                }
            }
        }

        //한 열씩 검사
        for (int i = 0; i < board.length; i++) {
            Set<Character> numCharSet = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (hasDuplicateChar(numCharSet, board[j][i])) {
                    return false;
                }
            }
        }

        //3x3 검사
        for (int i = 0; i < board.length; i+=3) {
            for (int j = 0; j < board.length; j+=3) {
                Set<Character> numCharSet = new HashSet<>();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (hasDuplicateChar(numCharSet, board[k][l])) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private boolean hasDuplicateChar(Set<Character> numCharSet, char c) {
        if (c == '.') {
            return false;
        }

        return !numCharSet.add(c);
    }
}

public class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] board1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] board2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        assertThat(solution.isValidSudoku(board1)).isEqualTo(true);
        assertThat(solution.isValidSudoku(board2)).isEqualTo(false);
    }
}
