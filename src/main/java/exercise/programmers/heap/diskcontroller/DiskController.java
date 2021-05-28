package exercise.programmers.heap.diskcontroller;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    class DiskJob implements Comparable<DiskJob> {
        private int requestTime;
        private int workingTime;

        DiskJob(int requestTime, int workingTime) {
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }

        @Override
        public int compareTo(DiskJob o) {
            return this.requestTime - o.requestTime;
        }
    }

    class DiskComparator implements Comparator<DiskJob> {
        @Override
        public int compare(DiskJob o1, DiskJob o2) {
            return o1.workingTime - o2.workingTime;
        }
    }

    public int solution(int[][] jobs) {
        int minTimes = 0;
        int presentTime = 0;
        PriorityQueue<DiskJob> disks = new PriorityQueue<>();
        PriorityQueue<DiskJob> waitingDisks = new PriorityQueue<>(new DiskComparator());

        for (int[] job : jobs) {
            disks.add(new DiskJob(job[0], job[1]));
        }

        while (!disks.isEmpty() || !waitingDisks.isEmpty()) {
            //현재시간 기준으로 기다리고 있던 작업이 있는지 확인하고 웨이팅디스크 큐에 넣음
            while (!disks.isEmpty() && presentTime >= disks.peek().requestTime) {
                waitingDisks.add(disks.poll());
            }

            //처리해야 할 작업은 있는데, 기다리는 건 없는 경우
            if (!disks.isEmpty() && waitingDisks.isEmpty()) {
                presentTime = disks.peek().requestTime;
            }

            //기다리고 있던 작업 중에서 가장 작업시간이 짧은 것부터 처리한다.
            while (!waitingDisks.isEmpty()) {
                DiskJob poll = waitingDisks.poll();

                minTimes += presentTime - poll.requestTime + poll.workingTime;
                presentTime += poll.workingTime;
            }
        }

        return minTimes / jobs.length;
    }
}

public class DiskController {
    public static void main(String[] args) {
//        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int[][] jobs = {{1, 3}, {10, 9}, {11, 6}, {11, 7}}; //11
//        int[][] jobs = {{1, 3}, {10, 9}, {11, 7}, {11, 6}}; //11
//        요청의 순서는 배열의 인덱스 기준이라고 하니 지금 위에 케이스와 위위에 케이스가 다른 결과를 뱉어야 한다. 허참.. ㅅㅂ
//        int[][] jobs = {{0, 9}, {0, 4}, {0, 5}, {0, 7}, {0, 3}}; //13

        Solution solution = new Solution();
        System.out.println(solution.solution(jobs));
    }
}
