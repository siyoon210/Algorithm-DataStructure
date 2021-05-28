package exercise.codility.lesson4.countingelements.maxcounters;

import java.util.ArrayList;
import java.util.List;

class Counter{
    private int index;
    private int value;
    private int lastIndexOfOperating;

    public Counter(int index) {
        this.index = index;
        this.value = 0;
        this.lastIndexOfOperating = -1;
    }

    public void increaseValue(int lastIndexOfOperatingMaxCounter, int maxValue) {
        if (this.lastIndexOfOperating < lastIndexOfOperatingMaxCounter) {
            this.value = maxValue;
        }
        this.value++;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getLastIndexOfOperating() {
        return lastIndexOfOperating;
    }

    public void setLastIndexOfOperating(int lastIndexOfOperating) {
        this.lastIndexOfOperating = lastIndexOfOperating;
    }
}

class Solution {
    public int[] solution(int N, int[] A) {
        List<Counter> counters = new ArrayList<>();
        int maxValue = 0;
        int maxValueOfOperatingMaxCounter = 0;
        int lastIndexOfOperatingMaxCounter = -1;

        for (int i = 1; i <= N; i++) {
            counters.add(new Counter(i));
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 1 && A[i] <= N) {
                Counter counter = counters.get(A[i] - 1);
                counter.increaseValue(lastIndexOfOperatingMaxCounter, maxValueOfOperatingMaxCounter);
                counter.setLastIndexOfOperating(i);
                maxValue = Math.max(maxValue, counter.getValue());
            } else if (A[i] == N + 1) {
                lastIndexOfOperatingMaxCounter = i;
                maxValueOfOperatingMaxCounter = maxValue;
            }
        }

        for (Counter counter : counters) {
            if (counter.getLastIndexOfOperating() < lastIndexOfOperatingMaxCounter) {
                counter.setValue(maxValueOfOperatingMaxCounter);
            }
        }

        return counters.stream()
                .mapToInt(Counter::getValue)
                .toArray();
    }
}

public class MaxCounters {
    public static void main(String[] args) {
        int N = 1;
        int[] A = {1};

//        int N = 5;
//        int[] A = {3, 4, 4, 6, 1, 4, 4,};

        Solution solution = new Solution();
        for (int i : solution.solution(N, A)) {
            System.out.print(i + ", ");
        }
    }
}
