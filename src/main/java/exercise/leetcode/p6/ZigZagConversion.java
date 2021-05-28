package exercise.leetcode.p6;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private class RowOfConvertedString {
        private StringBuilder str;

        private RowOfConvertedString() {
            this.str = new StringBuilder();
        }

        private void addChar(char c) {
            str.append(c);
        }
    }

    String convert(String s, int numRows) {
        List<RowOfConvertedString> rowOfConvertedStrings = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rowOfConvertedStrings.add(new RowOfConvertedString());
        }

        int pointer = 0;
        boolean isDownDirection = true;

        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            if (pointer + 1 == numRows) {
                isDownDirection = false;
            } else if (pointer == 0) {
                isDownDirection = true;
            }

            rowOfConvertedStrings.get(pointer).addChar(aChar);

            if (isDownDirection) {
                pointer++;
            } else {
                pointer--;
                if (pointer < 0) {
                    pointer = 0;
                }
            }
        }

        StringBuilder str = new StringBuilder();
        for (RowOfConvertedString rowOfConvertedString : rowOfConvertedStrings) {
            str.append(rowOfConvertedString.str);
        }

        return str.toString();
    }
}

public class ZigZagConversion {
    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;

        Solution solution = new Solution();
        System.out.println(solution.convert(s, numRows));
    }
}
