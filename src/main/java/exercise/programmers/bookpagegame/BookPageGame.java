package exercise.programmers.bookpagegame;

class Solution {
    public int solution(int[] pobi, int[] crong) {
        int answer = 0;
        //입력된 페이지가 예외적인 상황인지 아닌지 확인
        if (!checkValidPage(pobi) || !checkValidPage(crong)) {
            return -1;
        }

        int scoreOfPobi = calcMaxScore(pobi);
        int scoreOfCrong = calcMaxScore(crong);

        if (scoreOfPobi > scoreOfCrong) {
            answer = 1;
        } else if (scoreOfPobi < scoreOfCrong) {
            answer = 2;
        }
        return answer;
    }

    private boolean checkValidPage(int[] pages) {
        //400이상인 경우 (이건 문제에 명시되어 있음)
        if (pages[0] > 400) {
            return false;
        }

        //왼쪽 페이지는 홀수여야만 함
        if (pages[0] % 2 == 0) {
            return false;
        }

        //오른쪽 페이지는 왼쪽페이지보다 한페이지 높아야 함
        return pages[0] + 1 == pages[1];
    }

    private int calcMaxScore(int[] pages) {
        return Math.max(calcMaxScore(pages[0]), calcMaxScore(pages[1]));
    }

    private int calcMaxScore(int page) {
        if (page < 10) {
            return page;
        } else if (page < 100) {
            int i1 = page / 10;
            int i2 = page % 10;
            return Math.max(i1 + i2, i1 * i2);
        } else {
            int i1 = page / 100;
            int i2 = (page % 100) / 10;
            int i3 = (page % 100) % 10;
            return Math.max(i1 + i2 + i3, i1 * i2 * i3);
        }
    }
}

public class BookPageGame {
    public static void main(String[] args) {
        int[] pobi = {9, 10};
        int[] crong = {211, 212};

        Solution solution = new Solution();
        System.out.println(solution.solution(pobi, crong));
    }
}
