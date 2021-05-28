package exercise.programmers.stackqueue.top;

import java.util.EmptyStackException;
import java.util.Stack;

class Tower {
    private int index;
    private int height;

    public Tower(int index, int height) {
        this.index = index;
        this.height = height;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class Solution {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        Stack<Tower> towers = new Stack<>();
        Stack<Tower> tmp = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            towers.push(new Tower(i + 1, heights[i]));
        }

        while (!towers.empty()) {
            Tower pop = towers.pop();
            Tower peek = null;
            try {
                peek = towers.peek();
            } catch (EmptyStackException e) {
                while (!tmp.empty()) {
                    towers.push(tmp.pop());
                }
                continue;
            }

            if (peek.getHeight() > pop.getHeight()) {
                answer[pop.getIndex() - 1] = peek.getIndex();
                while (!tmp.empty()) {
                    towers.push(tmp.pop());
                }
            } else {
                tmp.push(towers.pop());
                towers.push(pop);
            }
        }

        return answer;
    }
}

public class Top {
    public static void main(String[] args) {
//        int[] heights = {6, 9, 5, 7, 4};
//        int[] heights = {3, 9,9,3,5,7,2};
        int[] heights = {1,5,3,6,7,6,5};

        Solution solution = new Solution();
        for (int i : solution.solution(heights)) {
            System.out.print(i + "\t");
        }
    }
}
