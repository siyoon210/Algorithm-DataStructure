package codingTest.wooa.wb2012.p1;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public static final String IMPOSSIBLE = "IMPOSSIBLE";
    public static final String ONE = "1";
    public static final String ZERO = "0";

    private static class Row {
        private final StringBuilder builder;
        private int value;

        public Row(int value) {
            builder = new StringBuilder();
            this.value = value;
        }

        public void addOne() {
            if (!remainValue()) {
                throw new IllegalStateException("남은 값이 0보다 같거나 작음");
            }

            builder.append(ONE);
            value--;
        }

        public void addZero() {
            builder.append(ZERO);
        }

        public boolean remainValue() {
            return value > 0;
        }

        public String getResult() {
            return builder.toString();
        }
    }

    public String solution(int U, int L, int[] C) {
        Row upper = new Row(U);
        Row lower = new Row(L);

        try {
            buildResultForEachArrayC(C, upper, lower);
        } catch (IllegalStateException e) {
            return IMPOSSIBLE;
        }

        if (upper.remainValue() || lower.remainValue()) {
            return IMPOSSIBLE;
        }

        return upper.getResult() + "," + lower.getResult();
    }

    private void buildResultForEachArrayC(int[] C, Row upper, Row lower) {
        for (int i : C) {
            if (i == 2) {
                upper.addOne();
                lower.addOne();
                continue;
            }

            if (i == 0) {
                upper.addZero();
                lower.addZero();
                continue;
            }

            if (upper.value >= lower.value) {
                upper.addOne();
                lower.addZero();
            } else {
                upper.addZero();
                lower.addOne();
            }
        }
    }
}

public class P1 {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        assertThat(solution.solution(3,2,new int[]{2,1,1,0,1})).isEqualTo("11001,10100");
        assertThat(solution.solution(3, 2, new int[]{2, 1, 1, 0, 1})).isEqualTo("11100,10001");
        assertThat(solution.solution(2, 3, new int[]{0, 0, 1, 1, 2})).isEqualTo("IMPOSSIBLE");
        assertThat(solution.solution(2, 2, new int[]{2, 0, 2, 0})).isEqualTo("1010,1010");
        assertThat(solution.solution(2, 2, new int[]{})).isEqualTo("IMPOSSIBLE");
        assertThat(solution.solution(2, 4, new int[]{2, 1, 1, 1, 1})).isEqualTo("10010,11101");


        out.println("p1" + " success!");
    }
}
