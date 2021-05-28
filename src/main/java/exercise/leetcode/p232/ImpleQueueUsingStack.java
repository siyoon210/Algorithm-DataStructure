package exercise.leetcode.p232;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class MyQueue {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }

        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.empty() && out.empty();
    }
}

public class ImpleQueueUsingStack {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);

        assertThat(queue.peek()).isEqualTo(1);
        assertThat(queue.pop()).isEqualTo(1);
        assertThat(queue.empty()).isEqualTo(false);
        assertThat(queue.pop()).isEqualTo(2);
        assertThat(queue.empty()).isEqualTo(true);
    }
}
