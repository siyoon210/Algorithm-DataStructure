package codingTest.toss20junior.p6;

import static org.assertj.core.api.Assertions.assertThat;

public class P6 {
    public static void main(String[] args) {
        assertThat(solution("0 0 0 0;0 1 1 0;0 0 1 0;0 0 0 0")).isEqualTo(8);
        System.out.println("p6 done");
    }

    private static int solution(String input) {
        int[][] array = getArrayFromInput(input);
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1) {
                    //상
                    if (isZero(array, i - 1, j)) {
                        answer++;
                    }
                    //하
                    if (isZero(array, i + 1, j)) {
                        answer++;
                    }
                    //좌
                    if (isZero(array, i, j - 1)) {
                        answer++;
                    }
                    //우
                    if (isZero(array, i, j + 1)) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    private static boolean isZero(int[][] array, int i, int j) {
        if (i < 0 || i >= array.length) {
            return false;
        }

        if (j < 0 || j >= array[0].length) {
            return false;
        }

        return array[i][j] == 0;
    }

    private static int[][] getArrayFromInput(String input) {
        final String[] splitI = input.split(";");
        int[][] arrays = new int[splitI.length][splitI[0].split(" ").length];

        for (int i = 0; i < splitI.length; i++) {
            final String[] splitJ = splitI[i].split(" ");
            for (int j = 0; j < splitJ.length; j++) {
                arrays[i][j] = Integer.parseInt(splitJ[j]);
            }
        }

        return arrays;
    }
}
