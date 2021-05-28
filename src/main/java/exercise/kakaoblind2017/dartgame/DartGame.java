package exercise.kakaoblind2017.dartgame;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String dartResult) {
        List<Integer> scores = new ArrayList<>();
        int scoresIndex = -1;

        for (int i = 0; i < dartResult.length(); i++) {
            final char c = dartResult.charAt(i);

            if (isNumber(c)) {
                if (c == '0' && scoresIndex != -1 && scores.get(scoresIndex) == 1) { //숫자 10인경우
                    scores.set(scoresIndex, 10);
                    continue;
                }

                scores.add(c - '0');
                scoresIndex++;
            } else if (isBonus(c)) {
                if (c == 'S') {
                    final Integer score = scores.get(scoresIndex);
                    scores.set(scoresIndex, (int) Math.pow(score, 1));
                } else if (c == 'D') {
                    final Integer score = scores.get(scoresIndex);
                    scores.set(scoresIndex, (int) Math.pow(score, 2));
                } else if (c == 'T') {
                    final Integer score = scores.get(scoresIndex);
                    scores.set(scoresIndex, (int) Math.pow(score, 3));
                }
            } else if (isOption(c)) {
                if (c == '*') {
                    final Integer score = scores.get(scoresIndex);
                    scores.set(scoresIndex, score * 2);

                    if (scoresIndex - 1 >= 0) {
                        final Integer preScore = scores.get(scoresIndex - 1);
                        scores.set(scoresIndex - 1, preScore * 2);
                    }
                } else if (c == '#') {
                    final Integer score = scores.get(scoresIndex);
                    scores.set(scoresIndex, -score);
                }
            }
        }

        int sum = 0;

        for (final Integer score : scores) {
//            System.out.println(score);
            sum += score;
        }
        return sum;
    }

    private boolean isNumber(final char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isBonus(final char c) {
        return c == 'S' || c == 'D' || c == 'T';
    }

    private boolean isOption(final char c) {
        return c == '*' || c == '#';
    }
}

public class DartGame {
    public static void main(String[] args) {
//        String dartResult = "1S2D*3T";
        String dartResult = "1D2S#10S";

        Solution solution = new Solution();
        System.out.println("solution.solution(dartResult) = " + solution.solution(dartResult));
    }
}
