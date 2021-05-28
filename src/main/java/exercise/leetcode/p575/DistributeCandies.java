package exercise.leetcode.p575;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> kindsOfCandies = new HashSet<>();
        for (int candy : candies) {
            kindsOfCandies.add(candy);
        }

        return Math.min(candies.length / 2, kindsOfCandies.size());
    }
}

public class DistributeCandies {
    public static void main(String[] args) {
        int[] candies = {
                1, 1, 2, 2, 3, 3
        };

        Solution solution = new Solution();
        System.out.println(solution.distributeCandies(candies));
    }
}
