package exercise.kakaoblind2018.mizimukbang;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Food {
        private int index;
        private int times;

        Food(final int index, final int times) {
            this.index = index;
            this.times = times;
        }

        void eatOneTime() {
            times--;
        }

        boolean isAllEaten() {
            if (times == 0) {
                return true;
            } else if (times > 0) {
                return false;
            }

            System.out.println("먹은 횟수가 음수야! 뭔가 이상");
            return false;
        }

        public int getIndex() {
            return index;
        }
    }

    public int solution(int[] foodTimes, long k) {
        Queue<Food> foodQueue = new LinkedList<>();

        for (int i = 0; i < foodTimes.length; i++) {
            foodQueue.add(new Food(i + 1, foodTimes[i]));
        }

        int secTime = 0;
        while (!foodQueue.isEmpty() && secTime != k) {
            final Food pollFood = foodQueue.poll();
            if (pollFood.isAllEaten()) {
                continue;
            }

            pollFood.eatOneTime();
            foodQueue.add(pollFood);
            secTime++;
        }

        return secTime == k && !foodQueue.isEmpty() ? foodQueue.peek().getIndex() : -1;
    }
}

public class MuziMukBang {
    public static void main(String[] args) {
        int[] foodTimes = {3, 1, 2};
        long k = 5;

        Solution solution = new Solution();
        System.out.println("solution.solution(foodTimes, k) = " + solution.solution(foodTimes, k));
    }
}
