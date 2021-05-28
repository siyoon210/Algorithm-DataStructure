package exercise.leetcode.p1859;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class P1859 {
    static class Word implements Comparable<Word> {
        private final String value;
        private final int sequence;

        public Word(String value) {
            this.value = value.substring(0, value.length() - 1);
            this.sequence = value.charAt(value.length() - 1);
        }

        @Override
        public int compareTo(Word o) {
            return Integer.compare(this.sequence, o.sequence);
        }

        @Override
        public String toString() {
            return "Word{" +
                    "value='" + value + '\'' +
                    ", sequence=" + sequence +
                    '}';
        }
    }

    static class Solution {
        public String sortSentence(String s) {
            return Arrays.stream(s.split(" "))
                    .map(Word::new)
                    .sorted()
                    .map(w -> w.value)
                    .collect(Collectors.joining(" "));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.sortSentence("is2 sentence4 This1 a3")).isEqualTo("This is a sentence");
        assertThat(solution.sortSentence("Myself2 Me1 I4 and3")).isEqualTo("Me Myself and I");
    }
}
