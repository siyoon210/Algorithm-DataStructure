package exercise.programmers.bruteforcesearch.findingprimenumber;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String numbers) {
        int answer = 0;

        //스트링으로 숫자 만들기
        Set<Integer> integers = convertStringToNumbers(numbers);

        //소수 찾기
        for (Integer integer : integers) {
            if (isPrime(integer)) {
                System.out.println(integer);
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    private Set<Integer> convertStringToNumbers(String number) {
        Set<Integer> integers = new HashSet<>();
        char[] chars = number.toCharArray();
        int[] flag = new int[chars.length];

        powerSet(chars, flag, 0, integers);

        return integers;
    }

    private void permutation(char[] chars, int depth, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(chars[i] + "\t");
            }
            return;
        }

        for (int i = depth; i < chars.length; i++) {
            char tmp = chars[depth];
            chars[depth] = chars[i];
            chars[i] = tmp;

            permutation(chars, depth + 1, r);

            //스왑한거 다시 되돌리기
            chars[i] = chars[depth];
            chars[depth] = tmp;
        }
    }

    private void powerSet(char[] chars, int[] flag, int depth, Set<Integer> integers) {
        if (depth == chars.length) {
            charToInt(chars, flag, integers);
            return;
        }

        flag[depth] = 0;
        powerSet(chars, flag, depth + 1, integers);

        flag[depth] = 1;
        powerSet(chars, flag, depth + 1, integers);
    }

    private void charToInt(char[] chars, int[] flag, Set<Integer> integers) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == 1) {
                sb.append(chars[i]);
            }
        }

        int parseInt = 0;
        try {
            parseInt = Integer.parseInt(sb.toString());
            if (parseInt >= 2) {
                integers.add(parseInt);
            }
        } catch (NumberFormatException e) {

        }
    }
}

public class FindingPrimeNumber {
    public static void main(String[] args) {
        String numbers = "011";
        Solution solution = new Solution();
        System.out.println(solution.solution(numbers));
    }
}
