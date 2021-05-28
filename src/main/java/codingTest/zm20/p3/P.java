package codingTest.zm20.p3;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class Solution {
    public int solution(int[] A) {
        int answer = 0;

        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                boolean isAesthetic = isAestheticWithAdjacent(A[i], A[i + 1], A[i + 2]);
                if (!isAesthetic) {
                    boolean isAestheticWithRemoval = isAestheticWithAdjacent(A[i + 1], A[i + 2], A[i + 3]);

                    if (isAestheticWithRemoval) {
                        answer++;
                    } else {
                        return -1;
                    }
                }
                continue;
            }

            if (i == A.length - 1) {
                boolean isAesthetic = isAestheticWithAdjacent(A[i - 2], A[i - 1], A[i]);
                if (!isAesthetic) {
                    boolean isAestheticWithRemoval = isAestheticWithAdjacent(A[i - 3], A[i - 2], A[i - 1]);

                    if (isAestheticWithRemoval) {
                        answer++;
                    } else {
                        return -1;
                    }
                }
                continue;
            }

            boolean isAesthetic = isAestheticWithAdjacent(A[i - 1], A[i], A[i + 1]);
            boolean isAestheticWithRemoval = false;
            try {
                isAestheticWithRemoval = isAestheticWithAdjacent(A[i - 1], A[i + 1], A[i + 2]);
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }

            if (!isAesthetic && isAestheticWithRemoval) {
                answer++;
            } else if (!isAesthetic) {
                return -1;
            }
        }

        return answer;
    }

    private boolean isAestheticWithAdjacent(int left, int center, int right) {
        return ((left > center && center < right) || (left < center && center > right));
    }
}

public class P {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new int[]{3, 4, 5, 3, 7})).isEqualTo(3);
        assertThat(solution.solution(new int[]{1, 2, 3, 4})).isEqualTo(-1);
        assertThat(solution.solution(new int[]{1, 3, 1, 2})).isEqualTo(0);
    }
}