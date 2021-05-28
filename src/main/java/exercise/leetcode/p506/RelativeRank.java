package exercise.leetcode.p506;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, String> decorateMedalMap = new HashMap<>();

    public String[] findRelativeRanks(final int[] nums) {
        Integer[] sortedNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortedNums[i] = nums[i];
        }
        Arrays.sort(sortedNums, Collections.reverseOrder());

        setDecorateMedalMap();
        Map<Integer, String> numAndRankMap = initNumRankMap(sortedNums);

        String[] answer = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = numAndRankMap.get(nums[i]);
        }
        return answer;
    }

    private void setDecorateMedalMap() {
        decorateMedalMap.put(1, "Gold Medal");
        decorateMedalMap.put(2, "Silver Medal");
        decorateMedalMap.put(3, "Bronze Medal");
    }

    private Map<Integer, String> initNumRankMap(final Integer[] sortedNums) {
        Map<Integer, String> numAndRankMap = new HashMap<>();
        for (int i = 0; i < sortedNums.length; i++) {
            String rank = decorateMedal(i);
            numAndRankMap.put(sortedNums[i], rank);
        }
        return numAndRankMap;
    }

    private String decorateMedal(final int i) {
        if (decorateMedalMap.containsKey(i + 1)) {
            return decorateMedalMap.get(i + 1);
        }

        return String.valueOf(i + 1);
    }
}

public class RelativeRank {
    public static void main(String[] args) {
        int[] nums = {5, 1, 3, 2, 4};

        Solution solution = new Solution();
        Arrays.stream(solution.findRelativeRanks(nums)).forEach(System.out::println);
    }
}
