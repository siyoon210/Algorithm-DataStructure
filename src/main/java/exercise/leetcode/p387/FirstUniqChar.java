package exercise.leetcode.p387;

import java.util.ArrayList;
import java.util.List;

//387번문제
class Char {
    private char charater;
    private boolean duplication;

    public Char(char charater) {
        this.charater = charater;
        this.duplication = false;
    }

    public char getCharater() {
        return charater;
    }

    public void setCharater(char charater) {
        this.charater = charater;
    }

    public boolean isDuplication() {
        return duplication;
    }

    public void setDuplication(boolean duplication) {
        this.duplication = duplication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Char aChar = (Char) o;

        return charater == aChar.charater;
    }

    @Override
    public int hashCode() {
        return (int) charater;
    }
}

class Solution {
    public int firstUniqChar(String s) {
        List<Char> chars = new ArrayList<>();
        for (char c : s.toCharArray()) {
            Char aChar = new Char(c);
            if (!chars.contains(aChar)) {
                chars.add(aChar);
            } else {
                Char getChar = chars.get(chars.indexOf(aChar));
                getChar.setDuplication(true);
            }
        }

        char answer = 0;
        for (Char aChar : chars) {
            if (!aChar.isDuplication()) {
                answer = aChar.getCharater();
                break;
            }
        }

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (answer == charArray[i]) {
                return i;
            }
        }

        return -1;
    }
}

public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "leetcode";

        Solution solution = new Solution();
        int i = solution.firstUniqChar(s);
        System.out.println(i);
    }
}
