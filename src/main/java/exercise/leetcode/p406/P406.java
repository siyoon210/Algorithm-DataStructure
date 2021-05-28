package exercise.leetcode.p406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 배열을 Person의 트리맵으로 넣는 과정 -> N logN
 * 적절한 위치를 찾아가는 과정이 최악의경우 N^2
 * (N longN) + N^2 => O(N^2)
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o2[0] - o1[0] != 0 ? o2[0] - o1[0] : o1[1] - o2[1]);

        List<int[]> list = new ArrayList<>();

        for (int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(new int[][]{});
    }
}

public class P406 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}})).isEqualTo(new int[][]{{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}});
    }
}
