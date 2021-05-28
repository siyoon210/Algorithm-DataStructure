package exercise.leetcode.p728;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> selfDividingNumbers = new ArrayList<>();

        loop:
        for (int i = left; i <= right; i++) {
            for (char c : String.valueOf(i).toCharArray()) {
                int fragmnet = c - '0';

                if (fragmnet == 0 || i % (fragmnet) != 0) {
                    continue loop;
                }
            }
            selfDividingNumbers.add(i);
        }

        return selfDividingNumbers;
    }
}

public class SelfDividingNumbers {
    public static void main(String[] args) {
        int left = 1;
        int right = 22;

        Solution solution = new Solution();
        for (Integer integer : solution.selfDividingNumbers(left, right)) {
            System.out.print(integer + "\t");
        }
    }
}
