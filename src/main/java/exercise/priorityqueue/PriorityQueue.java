package exercise.priorityqueue;

import java.util.Collections;

class MyClass{
    int index;

    public MyClass(int index) {
        this.index = index;
    }
}
class PriorityQueue {
    public static void main(String[] args) {
        //Collections.reverseOrder를 이
//        java.util.PriorityQueue<Integer> priorityQueue = new java.util.PriorityQueue<>(Collections.reverseOrder());
        java.util.PriorityQueue<Integer> priorityQueue = new java.util.PriorityQueue<>();
        priorityQueue.add(4);
        priorityQueue.add(3);
        priorityQueue.add(2);
        priorityQueue.add(1);

//        priorityQueue.offer(4);
//        priorityQueue.offer(3);
//        priorityQueue.offer(2);
//        priorityQueue.offer(1);

        Integer poll = priorityQueue.poll();
        System.out.println(poll);
    }
}
