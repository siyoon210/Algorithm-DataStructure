package exercise.leetcode.p169;

class Solution {
    //    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            if (!map.containsKey(num)) {
//                map.put(num, 1);
//            } else {
//                map.put(num, map.get(num) + 1);
//            }
//        }
//
//        int maxValue = map.entrySet().stream().mapToInt(key -> key.getValue()).max().getAsInt();
//
//        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
//            if (integerIntegerEntry.getValue() == maxValue) {
//                return integerIntegerEntry.getKey();
//            }
//        }
//
//        return 0;
//    }

    //19.12.19 과반수 알고리즘으로 풀
public int majorityElement(int[] nums) {
    int x = 0, cnt = 0;

    for (int num : nums) {
        if (cnt == 0) {
            x = num;
            cnt++;
        } else if (x == num) {
            cnt++;
        } else {
            cnt--;
        }
    }

    return x;
}
}

public class MajorityElement {
    public static void main(String[] args) {
//        int[] nums = {3, 2, 3};
        int[] nums = {2, 2, 1, 1, 1, 2, 2,};
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(nums));
    }
}
