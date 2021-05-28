package exercise.leetcode.p682;

import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> sumStack = new Stack<>();
        sumStack.add(0);

        LinkedList<String> rounds = new LinkedList<>();
        for (String op : ops) {
            rounds.add(op);
        }

        for (int i = 0; i < rounds.size(); i++) {
            switch (rounds.get(i)) {
                case "+":
                    sum += sumStack.get(sumStack.size() - 1) + sumStack.get(sumStack.size() - 2);
                    sumStack.push(sum);
                    rounds.remove(i);
                    i--;
                    break;
                case "D":
                    sum += Integer.parseInt(rounds.get(i - 1)) * 2;
                    sumStack.push(Integer.parseInt(rounds.get(i - 1)) * 2);
                    rounds.remove(i);
                    i--;
                    break;
                case "C":
                    sumStack.pop();
                    sum -= Integer.parseInt(rounds.get(i - 1));
                    sumStack.push(sum);
                    rounds.remove(i);
                    rounds.remove(i - 1);
                    i -= 2;
                    break;
                default:
                    sum += Integer.parseInt(rounds.get(i));
                    sumStack.push(sum);
                    break;
            }
        }

        return sum;
    }
}

public class BaseballGame {
    public static void main(String[] args) {
        String[] ops = {"4", "D", "D", "C", "D"};

        Solution solution = new Solution();
        System.out.println(solution.calPoints(ops));
    }
}
