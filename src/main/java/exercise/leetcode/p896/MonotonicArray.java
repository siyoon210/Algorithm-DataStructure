package exercise.leetcode.p896;

class Solution {
    enum Status {
        None, Increasing, Decreasing
    }

    public boolean isMonotonic(int[] A) {
        Status arrayStatus = Status.None;

        for (int i = 0; i < A.length - 1; i++) {
            Status presentStatus = getStatus(A, i);

            if (isNotMonotonicFlow(arrayStatus, presentStatus)) return false;

            if (arrayStatus == Status.None) arrayStatus = presentStatus;
        }

        return true;
    }

    private boolean isNotMonotonicFlow(Status arrayStatus, Status presentStatus) {
        if (presentStatus == Status.Increasing && arrayStatus == Status.Decreasing) {
            return true;
        }

        return presentStatus == Status.Decreasing && arrayStatus == Status.Increasing;
    }

    private Status getStatus(int[] A, int i) {
        if (A[i] < A[i + 1]) {
            return Status.Increasing;
        } else if (A[i] > A[i + 1]) {
            return Status.Decreasing;
        }

        return Status.None;
    }
}

public class MonotonicArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 2, 3};

        Solution solution = new Solution();
        System.out.println(solution.isMonotonic(A));
    }
}
