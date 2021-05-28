package codingTest.toss20junior.p2;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class P2 {
    public static void main(String[] args) {
//        assertThat(solution("1 2 3 4 5 6")).isTrue();
        assertThat(solution("1 3 5 7 7 9")).isFalse();
        assertThat(solution("1 2 4 5 6")).isFalse();
        assertThat(solution("2 1 3 5 7 9")).isFalse();
        assertThat(solution("46 1 3 5 7 9")).isFalse();
        System.out.println("p2 done");
    }

    private static final Integer AVAILABLE_MIN_NUM = 1;
    private static final Integer AVAILABLE_MAX_NUM = 45;

    private static boolean solution(String input) {
        final String[] strNums = input.split(" ");

        if (strNums.length != 6) {
            return false;
        }

        Integer preNum = null;

        for (String strNum : strNums) {
            final int i = Integer.parseInt(strNum);
            if (i < AVAILABLE_MIN_NUM || i > AVAILABLE_MAX_NUM) {
                return false;
            }

            if (preNum == null) {
                preNum = i;
                continue;
            }

            if (preNum >= i) {
                return false;
            }

            preNum = i;
        }

        return true;
    }
}
