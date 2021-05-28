package codingTest.toss20junior.p3;

import java.util.HashMap;
import java.util.Map;

public class P3 {
    public static void main(String[] args) {
        System.out.println("solution(\"1 2 3 4 5 6\") = " + solution("1 2 3 1 2 4"));
    }

    private static String solution(String input) {
        final String[] strNums = input.split(" ");
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < strNums.length; i++) {
            final String strNum = strNums[i];
            if (map.containsKey(strNum)) {
                strNums[i] = map.get(strNum);
                continue;
            }

            String result = String.valueOf(FunctionCompute(Integer.parseInt(strNum)));
            map.put(strNum, result);
            strNums[i] = result;
        }

        return String.join(" ", strNums);
    }

    private static int FunctionCompute(int i) {
        return i * 100;
    }
}
