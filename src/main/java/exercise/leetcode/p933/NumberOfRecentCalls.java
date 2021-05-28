package exercise.leetcode.p933;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList();
    }

    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000)
            q.poll();
        return q.size();
    }
}

public class NumberOfRecentCalls {
    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        int param_1 = obj.ping(100);
    }
}
