package exercise.programmers.p12915;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    static class MyString implements Comparable<MyString> {
        String string;
        int n;

        public MyString(String string, int n) {
            this.string = string;
            this.n = n;
        }

        @Override
        public int compareTo(MyString o) {
            final char[] chars1 = this.string.toCharArray();
            final char[] chars2 = o.string.toCharArray();

            while (n < chars1.length) {
                if (chars1[n] > chars2[n]) {
                    return 1;
                } else if (chars1[n] < chars2[n]) {
                    return -1;
                }
                n++;
            }

            return 0;
        }
    }

    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
                .map(s -> new MyString(s, n))
                .sorted()
                .map(m -> m.string)
                .toArray(String[]::new);
    }
}

public class P12915 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new String[]{"sun", "bed", "car"}, 1)).isEqualTo(new String[]{"car", "bed", "sun"});
        assertThat(solution.solution(new String[]{"abce", "abcd", "cdx"}, 2)).isEqualTo(new String[]{"abcd", "abce", "cdx"});
    }
}
