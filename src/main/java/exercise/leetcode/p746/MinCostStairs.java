package exercise.leetcode.p746;

//746. Min Cost Climbing Stairs
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];
        int i = calcMinCost(minCost, cost, 0);
        return i;
    }

    int calcMinCost(int[] minCost, int[] cost, int depth) {
        //제일 끝에 있는건 바로 리턴
        if (depth >= minCost.length - 2) {
            return cost[depth];
        }

        if (minCost[depth] != 0) {
            return minCost[depth];
        }

        minCost[depth] = Math.min(cost[depth] + calcMinCost(minCost, cost, depth + 1),
                cost[depth] + calcMinCost(minCost, cost, depth + 2));

        if (depth == 0) {
            return Math.min(minCost[0], minCost[1]);
        }
        return minCost[depth];
    }
}

public class MinCostStairs {
    public static void main(String[] args) {
//        int[] cost = {10, 15, 20};
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(cost));
    }
}
