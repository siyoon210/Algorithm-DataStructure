package exercise.leetcode.p621;

import java.util.*;

class Solution {
    class Task implements Comparable<Task> {
        private char name;
        private int count;
        private int lastProcessedPeriod;
        private boolean isMaxCountTask;

        public Task(final char name, final int count) {
            this.name = name;
            this.count = count;
            lastProcessedPeriod = -1;
            isMaxCountTask = false;
        }

        @Override
        public int compareTo(final Task o) {
            return o.count - count;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Task task = (Task) o;

            return name == task.name;

        }

        @Override
        public int hashCode() {
            return (int) name;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        Queue<Task> taskQueue = getTaskQueue(tasks);

        int period = 0;

        while (!taskQueue.isEmpty()) {
            if (isPossibleToProcess(n, taskQueue, period)) {
                Task pollTask = taskQueue.poll();
                pollTask.count--;
                pollTask.lastProcessedPeriod = period;

                if (pollTask.count > 0) {
                    taskQueue.add(pollTask);
                }
            } else {
                if (taskQueue.peek().isMaxCountTask) {
                    period += (n - (period - taskQueue.peek().lastProcessedPeriod - 1));
                    continue;
                }

                taskQueue.add(taskQueue.poll());
            }

            period++;
        }

        return period;
    }

    private Queue<Task> getTaskQueue(final char[] tasks) {
        Map<Character, Integer> taskAndCountMap = getTaskAndCountMap(tasks);

        List<Task> taskList = new LinkedList<>();
        for (final Character character : taskAndCountMap.keySet()) {
            taskList.add(new Task(character, taskAndCountMap.get(character)));
        }

        Collections.sort(taskList);

        setMaxCountTask(taskList);

        return (Queue) taskList;
    }

    private void setMaxCountTask(final List<Task> taskList) {
        if (taskList.size() > 0) {
            taskList.get(0).isMaxCountTask = true;
        }
    }

    private Map<Character, Integer> getTaskAndCountMap(final char[] tasks) {
        Map<Character, Integer> taskAndCountMap = new HashMap<>();

        for (final char task : tasks) {
            if (taskAndCountMap.containsKey(task)) {
                taskAndCountMap.put(task, taskAndCountMap.get(task) + 1);
                continue;
            }
            taskAndCountMap.put(task, 1);
        }
        return taskAndCountMap;
    }

    private boolean isPossibleToProcess(final int n, final Queue<Task> taskQueue, final int period) {
        return n < (period - taskQueue.peek().lastProcessedPeriod) || taskQueue.peek().lastProcessedPeriod == -1;
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        Solution solution = new Solution();
        System.out.println("solution.leastInterval(tasks, n) = " + solution.leastInterval(tasks, n));
    }
}
