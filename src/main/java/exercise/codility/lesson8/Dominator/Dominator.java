package exercise.codility.lesson8.Dominator;

import java.util.*;

class Solution {
    class Value implements Comparable<Value> {
        private int index;
        private int value;
        private int count;

        public Value(int index, int value) {
            this.index = index;
            this.value = value;
            count = 1;
        }

        public void addCount() {
            count++;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Value o) {
            return o.count - count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Value)) return false;

            Value value1 = (Value) o;

            return value == value1.value;

        }

        @Override
        public int hashCode() {
            return value;
        }
    }

    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        Set<Value> values = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (values.add(new Value(i, A[i]))) {
                continue;
            }

            addCount(A[i], values);
        }

        Value answerValue = new Value(-1, 0);

        for (Value v : values) {
            if (v.count > answerValue.count) {
                answerValue = v;
            }
        }

        return answerValue.count > A.length / 2 ? answerValue.index : -1;
    }

    private void addCount(int i, Set<Value> values) {
        for (Value v : values) {
            if (v.value == i) {
                v.addCount();
            }
        }
    }
}

public class Dominator {
    public static void main(String[] args) {
        int[] A = {
        };

        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }
}
