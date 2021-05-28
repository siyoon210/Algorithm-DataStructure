package codingTest.kaka0.kaka02011.p1;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public static String solution(long n) {
        Map<Integer, String> columnSequence = initColumnSequenceMap();

        long row = (n / (columnSequence.size())) + 1;
        final long l = (n / columnSequence.size());
        for (long i = 0; i < l; i++) {
            n -= columnSequence.size();
        }

        if (n <= 0) {
            n = 702;
            row -= 1;
        }

        String column = columnSequence.get((int) n);

        return row + column;
    }

    private static Map<Integer, String> initColumnSequenceMap() {
        Map<Integer, String> columnSequence = new HashMap<>();
        int sequence = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            columnSequence.put(sequence++, String.valueOf(c));
        }

        for (char c1 = 'A'; c1 <= 'Z'; c1++) {
            for (char c2 = 'A'; c2 <= 'Z'; c2++) {
                columnSequence.put(sequence++, String.valueOf(c1) + c2);
            }
        }
        return columnSequence;
    }
}

public class P1 {
    public static void main(String[] args) {
        assertThat(Solution.solution(27)).isEqualTo("1AA");
        assertThat(Solution.solution(703)).isEqualTo("2A");
        assertThat(Solution.solution(702)).isEqualTo("1ZZ");
        assertThat(Solution.solution(140443)).isEqualTo("201AQ");

        out.println("p1" + " success!");
    }
}
