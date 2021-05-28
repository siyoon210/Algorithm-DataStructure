package exercise.programmers.p42841;

import java.util.HashSet;
import java.util.Set;

class Solution {
    private Set<Integer> numOfCases;

    Solution() {
        numOfCases = new HashSet<>();
        for (int i = 123; i <= 987; i++) {
            if (isValidNum(i)) {
                numOfCases.add(i);
            }
        }
    }

    public int solution(int[][] baseball) {
        for (int[] ints : baseball) {
            Set<Integer> specificNumOfCases = new HashSet<>();

        }

        return numOfCases.size();
    }

    private void calcNumOfCase(int[] result) {
        if (isValidNum(result[0])) {

        }
    }

    private boolean isValidNum(int num) {
        //123이상 987 이하인 경우만 확인한다.
        if (num < 123 || num > 987) {
            return false;
        }

        //각 자리수가 같은 숫자가 있으면 안됨
        int i1 = num / 100; //백의자리
        int i2 = (num / 10) % 10; //십의자리
        int i3 = (num % 100) % 10; //일의자리
        if ((i1 == i2) || (i1 == i3) || (i2 == i3)) {
            return false;
        }

        //각 자리수에 0이 있으면 안됨
        return (i2 != 0 && i3 != 0);
    }
}

public class NumBaseball {
    public static void main(String[] args) {
        int[][] baseball = {
                {123, 1, 1},
                {356, 1, 0},
                {327, 2, 0},
                {489, 0, 1},
        };

        Solution solution = new Solution();
        System.out.println(solution.solution(baseball));
    }
}
