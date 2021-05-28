package exercise.leetcode.p225;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class MyStack {
    Queue<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
public void push(int x) {
    final int size = queue.size();
    queue.offer(x);
    for (int i = 0; i < size; i++) {
        queue.offer(queue.remove());
    }
}

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

public class ImplStackUsingQueue {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        assertThat(stack.top()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.empty()).isEqualTo(false);
    }
}
