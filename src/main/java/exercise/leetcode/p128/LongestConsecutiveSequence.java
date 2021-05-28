package exercise.leetcode.p128;

import java.util.HashMap;
import java.util.Map;

//가장 끝에 숫자들만 연속된 숫자를 가지고 있으면 된다.
//(굳이 같은 참조를 다 가지고 있을 필요가 없었어.)
class Solution {
    public int longestConsecutive(int[] nums) {
        int longestSequence = 0;
        Map<Integer, Integer> numAndSequence = new HashMap<>();

        for (int num : nums) {
            if (numAndSequence.containsKey(num)) {
                continue;
            }

            if (numAndSequence.containsKey(num - 1) && numAndSequence.containsKey(num + 1)) {
                int leftSequence = numAndSequence.get(num - 1);
                int rightSequence = numAndSequence.get(num + 1);
                int sumOfSequenceCount = leftSequence + rightSequence + 1;

                numAndSequence.put(num - leftSequence, sumOfSequenceCount);
                numAndSequence.put(num + rightSequence, sumOfSequenceCount);

                numAndSequence.put(num, sumOfSequenceCount);

                longestSequence = Math.max(longestSequence, sumOfSequenceCount);
                continue;
            }

            if (numAndSequence.containsKey(num - 1)) {
                int leftSequence = numAndSequence.get(num - 1);
                int sumOfSequenceCount = leftSequence + 1;

                numAndSequence.put(num - leftSequence, sumOfSequenceCount);
                numAndSequence.put(num, sumOfSequenceCount);

                longestSequence = Math.max(longestSequence, sumOfSequenceCount);
                continue;
            }

            if (numAndSequence.containsKey(num + 1)) {
                int rightSequence = numAndSequence.get(num + 1);
                int sumOfSequenceCount = rightSequence + 1;

                numAndSequence.put(num + rightSequence, sumOfSequenceCount);
                numAndSequence.put(num, sumOfSequenceCount);

                longestSequence = Math.max(longestSequence, sumOfSequenceCount);
                continue;
            }

            numAndSequence.put(num, 1);
            longestSequence = Math.max(longestSequence, 1);
        }

        return longestSequence;
    }
}

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
//        int[] nums = {-4, -1, 4, -5, 1, -6, 0, 2, -3, 5, 3, -2};
        int[] nums = {-4, -1, 4, -5, 1, -6, 9, -6, 0, 2, 2, 7, 0, 9, -3, 8, 9, -2, -6, 5, 0, 3, 4, -2};
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(nums));
    }
}
