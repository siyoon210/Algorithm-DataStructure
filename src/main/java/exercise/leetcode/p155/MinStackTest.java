package exercise.leetcode.p155;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class MinStack {
    static class Node {
        int val;
        int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    Stack<Node> stack = new Stack<>();
    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if (stack.empty()) {
            stack.push(new Node(x, x));
        } else {
            stack.push(new Node(x, Math.min(x, stack.peek().min)));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        final Node peek = stack.peek();
        return peek.val;
    }

    public int getMin() {
        final Node peek = stack.peek();
        return peek.min;
    }
}

public class MinStackTest {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertThat(minStack.getMin()).isEqualTo(-3);
        minStack.pop();
        assertThat(minStack.top()).isEqualTo(0);
        assertThat(minStack.getMin()).isEqualTo(-2);
    }
}
