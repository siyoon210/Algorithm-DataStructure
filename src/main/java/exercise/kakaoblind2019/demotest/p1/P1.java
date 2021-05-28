package exercise.kakaoblind2019.demotest.p1;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[][] v) {
        int[] answer = new int[2];

        Set<Integer> coordinateX = new HashSet<>();
        Set<Integer> coordinateY = new HashSet<>();

        for (final int[] ints : v) {
            if (!coordinateX.add(ints[0])) {
                coordinateX.remove(ints[0]);
            }
            if (!coordinateY.add(ints[1])) {
                coordinateY.remove(ints[1]);
            }
        }

        answer[0] = coordinateX.iterator().next();
        answer[1] = coordinateY.iterator().next();
        return answer;
    }
}

public class P1 {
    public static void main(String[] args) {
        int[][] v = {{1, 4}, {3, 4}, {3, 10}};

        Solution solution = new Solution();
        for (final int i : solution.solution(v)) {
            System.out.print(i + " ");
        }
    }
}
