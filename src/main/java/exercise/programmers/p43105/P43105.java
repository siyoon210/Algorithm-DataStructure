package exercise.programmers.p43105;

import java.util.Arrays;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int solution(int[][] triangle) {
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                //왼쪽 부모로 부터 값 받아옴
                final int leftParentValue = getLeftParentValue(triangle, i, j);

                //오른쪽 부모로 부터 값 받아옴
                final int rightParentValue = getRightParentValue(triangle, i, j);

                //둘중에 더 큰 값을 더해서 자기자신에게 저장
                triangle[i][j] += Math.max(leftParentValue, rightParentValue);
            }
        }

        return Arrays.stream(triangle[triangle.length - 1])
                .max()
                .orElse(0);
    }

    private int getLeftParentValue(int[][] triangle, int i, int j) {
        int parentIndexI = i - 1;
        int parentIndexJ = j - 1;

        if (parentIndexI < 0 || parentIndexJ < 0) {
            return 0;
        }

        return triangle[parentIndexI][parentIndexJ];
    }

    private int getRightParentValue(int[][] triangle, int i, int j) {
        int parentIndexI = i - 1;

        if (parentIndexI < 0) {
            return 0;
        }

        if (j >= triangle[i - 1].length) {
            return 0;
        }

        return triangle[parentIndexI][j];
    }
}

public class P43105 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}})).isEqualTo(30);

        out.println("p43105" + " success!");
    }
}
