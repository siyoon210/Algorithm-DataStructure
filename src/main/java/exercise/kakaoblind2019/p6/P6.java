package exercise.kakaoblind2019.p6;

import java.util.*;

//효율성 없으니 완전탐색으로 조저보
class Solution {
    private int n;

    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        int answer = 0;

        final List<Integer> distances = getDistances(dist);
        Set<Integer> uncheckedWeakPositions;

        for (int i = 0; i< weak.length; i++) {
            for (int j = 0; j < distances.size(); j++) {
                uncheckedWeakPositions = getWeaks(weak);
                moveToClockwise(distances.get(j), weak[i], uncheckedWeakPositions);
                moveToAntiClockwise(distances.get(j), weak[i], uncheckedWeakPositions);
            }
        }

        return answer;
    }

    private void moveToClockwise(final Integer distance, final int startWeakPosition, final Set<Integer> uncheckedWeakPositions) {
        for (int step = 1; step <= distance; step++) {
            uncheckedWeakPositions.remove(calcPositon(startWeakPosition, step));
        }
    }

    private void moveToAntiClockwise(final Integer distance, final int startWeakPosition, final Set<Integer> uncheckedWeakPositions) {
        for (int step = 1; step <= distance; step++) {
            uncheckedWeakPositions.remove(calcPositon(startWeakPosition, -step));
        }
    }

    private Set<Integer> getWeaks(final int[] weak) {
        final Set<Integer> weaks = new HashSet<>();

        for (final int i : weak) {
            weaks.add(i);
        }
        return weaks;
    }

    private List<Integer> getDistances(final int[] dist) {
        final List<Integer> distance = new ArrayList<>();
        for (final int i : dist) {
            distance.add(i);
        }

        distance.sort(Collections.reverseOrder());
        return distance;
    }

    private int calcPositon(int num1, int num2) {
        int calcValue = num1 + num2;

        if (calcValue < 0) {
            return calcValue + n;
        }

        if (calcValue > n - 1) {
            return calcValue - n;
        }

        return calcValue;
    }
}

public class P6 {
    public static void main(String[] args) {
        int n = 12;
        int[] weak = {1, 5, 6, 10};
        int[] dist = {1, 2, 3, 4};

        Solution solution = new Solution();
        System.out.println("solution.solution(n, weak, dist) = " + solution.solution(n, weak, dist));
    }
}
