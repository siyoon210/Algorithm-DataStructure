package codingTest.toss20junior.p1;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class P1 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//        boolean output = solution(input);
        assertThat(solution("11")).isEqualTo(false);
        assertThat(solution("12")).isEqualTo(true);
        assertThat(solution("121")).isEqualTo(false);
        assertThat(solution("122")).isEqualTo(true);
    }

    private static boolean solution(String input) {
        for (int i = 0; i < input.length(); i++) {
            final char c = input.charAt(i);
            if (c == '1' && (i == input.length() - 1 || input.charAt(i + 1) != '2')) {
                return false;
            }
        }
        return true;
    }
}
