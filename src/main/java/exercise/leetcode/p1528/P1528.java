package exercise.leetcode.p1528;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    static class Character implements Comparable<Character> {
        private final char character;
        private final int index;

        public Character(char character, int index) {
            this.character = character;
            this.index = index;
        }

        @Override
        public int compareTo(Character o) {
            return this.index - o.index;
        }
    }

    public String restoreString(String s, int[] indices) {
        final List<Character> chars = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            chars.add(new Character(s.charAt(i), indices[i]));
        }

        Collections.sort(chars);

        final StringBuilder sb = new StringBuilder();

        for (Character aChar : chars) {
            sb.append(aChar.character);
        }

        return sb.toString();
    }
}

public class P1528 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3})).isEqualTo("leetcode");
        assertThat(solution.restoreString("aiohn", new int[]{3, 1, 4, 2, 0})).isEqualTo("nihao");

        out.println("p1528" + " success!");
    }
}
