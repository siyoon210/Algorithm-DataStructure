package exercise.leetcode.p1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    /** 방법1. (브루트 포스)
     * 시간 복잡도 O(n^2 - 이중 루프 / 공간 복잡도 O(1)
     */
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//
//        return null;
//    }

    /**
     * 방법2. 해쉬 사용
     * 시간 복잡도 O(n) - 루프 한번 / 공간 복잡도 O(n)
     */

    public int[] twoSum(int[] nums, int tartget) {
        Map<Integer, Integer> numAndIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            final int targetMinusNum = tartget - nums[i];
            if (numAndIndexMap.containsKey(targetMinusNum)) {
                return new int[]{numAndIndexMap.get(targetMinusNum), i};
            } else {
                numAndIndexMap.put(nums[i], i);
            }
        }

        return null;
    }
}

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};

        int target = 9;

        Solution solution = new Solution();

        assertThat(solution.twoSum(nums, target)).isEqualTo(new int[]{0,1});
    }
}
