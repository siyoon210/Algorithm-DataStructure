package exercise.programmers.stackqueue.stockprice;

import java.util.Stack;

class Stock{
    private int index;
    private int price;
    private int keptDays;

    public Stock(int index, int price) {
        this.index = index;
        this.price = price;
        this.keptDays = 0;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getKeptDays() {
        return keptDays;
    }

    public void increaseKeptDays() {
        this.keptDays++;
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Stock> stack = new Stack<>();
        Stack<Stock> tmpStack = new Stack<>();

        for (int i = prices.length - 1; i >= 0; i--) {
            stack.push(new Stock(i, prices[i]));
        }

        while (!stack.empty()) {
            Stock pop = stack.pop();

            if (!stack.empty() && stack.peek().getPrice() > pop.getPrice()) {
                pop.increaseKeptDays();
            }

            while (!stack.empty() && stack.peek().getPrice() > pop.getPrice()) {
                tmpStack.push(stack.pop());
            }

            if (!stack.empty()) {
                answer[pop.getIndex()] = stack.peek().getIndex() - pop.getIndex();
                if (stack.peek().getIndex() == prices.length - 1 && pop.getKeptDays() == 0) {
                    pop.increaseKeptDays();
                }
            }

            while (!tmpStack.empty()) {
                stack.push(tmpStack.pop());
            }

        }

        return answer;
    }
}

public class StockPrice {
    public static void main(String[] args) {
        int[] prices = {498, 501, 470, 489};

        Solution solution = new Solution();
        for (int i : solution.solution(prices)) {
            System.out.print(i + "\t");
        }
    }
}
