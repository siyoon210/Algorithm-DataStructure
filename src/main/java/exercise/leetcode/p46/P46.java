package exercise.leetcode.p46;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    int length;

    public List<List<Integer>> permute(int[] nums) {
        length = nums.length;

        permute(nums, 0);
        return answer;
    }

    private void permute(int[] nums, int i) {
        if (i >= length) {
            List<Integer> integers = new ArrayList<>();

            for (int num : nums) {
                integers.add(num);
            }

            answer.add(integers);
            return;
        }

        for (int j = i; j < length; j++) {
            swap(nums, i, j);
            permute(nums, i + 1);
            swap(nums, i, j);
        }
    }

    private int[] swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return nums;
    }
}

public class P46 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        final List<List<Integer>> permute = solution.permute(new int[]{1, 2, 3});
        for (List<Integer> integerList : permute) {
            System.out.println(
                    integerList.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(", "))
            );
        }
    }
}
