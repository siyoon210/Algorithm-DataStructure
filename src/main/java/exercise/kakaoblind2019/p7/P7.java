package exercise.kakaoblind2019.p7;

// 로봇 움직임 경우의수 (총 8가지)
// 상,하,좌,우로 이동
// 축1을 기준으로 90도 시계회전, 반시계회전
// 축2를 기준으로 90도 시계회전, 반시계 회전
class Solution {
    static class Robot {
        int[][] board;

        static class Coordinate {
            int i;
            int j;

            Coordinate(final int i, final int j) {
                this.i = i;
                this.j = j;
            }
        }

        Coordinate coordinate1;
        Coordinate coordinate2;

        Robot(final int[][] board, final Coordinate coordinate1, final Coordinate coordinate2) {
            this.board = board;
            this.coordinate1 = coordinate1;
            this.coordinate2 = coordinate2;
        }

        boolean moveToTop() { //i 좌표가 1씩 감소한다.
            if (validateCoordinate(coordinate1.i - 1, coordinate1.j) && validateCoordinate(coordinate2.i - 1, coordinate2.j)) {
                coordinate1.i--;
                coordinate2.i--;
                return true;
            }

            return false;
        }

        boolean moveToDown() {  //i 좌표가 1씩 증가한다.
            if (validateCoordinate(coordinate1.i + 1, coordinate1.j) && validateCoordinate(coordinate2.i + 1, coordinate2.j)) {
                coordinate1.i++;
                coordinate2.i++;
                return true;
            }

            return false;
        }

        boolean moveToLeft() {  //j 좌표가 1씩 감소한다.
            if (validateCoordinate(coordinate1.i, coordinate1.j - 1) && validateCoordinate(coordinate2.i, coordinate2.j - 1)) {
                coordinate1.j--;
                coordinate2.j--;
                return true;
            }

            return false;
        }

        boolean moveToRight() {  //j 좌표가 1씩 증가한다.
            if (validateCoordinate(coordinate1.i, coordinate1.j + 1) && validateCoordinate(coordinate2.i, coordinate2.j + 1)) {
                coordinate1.j++;
                coordinate2.j++;
                return true;
            }

            return false;
        }

        boolean spinClockwiseBaseOnCoordinate1() {
            if (coordinate1.i == coordinate2.i) {
                if (validateCoordinate(coordinate2.i + 1, coordinate2.j) && validateCoordinate(coordinate2.i + 1, coordinate2.j - 1)) {
                    coordinate2.i++;
                    coordinate2.j--;
                    return true;
                }
            } else {
                if (validateCoordinate(coordinate2.i, coordinate2.j - 1) && validateCoordinate(coordinate2.i - 1, coordinate2.j - 1)) {
                    coordinate2.i--;
                    coordinate2.j--;
                    return true;
                }
            }

            return false;
        }

        boolean spinAntiClockwiseBaseOnCoordinate1() {
            if (coordinate1.i == coordinate2.i) {
                if (validateCoordinate(coordinate2.i - 1, coordinate2.j) && validateCoordinate(coordinate2.i - 1, coordinate2.j - 1)) {
                    coordinate2.i--;
                    coordinate2.j--;
                    return true;
                }
            } else {
                if (validateCoordinate(coordinate2.i, coordinate2.j + 1) && validateCoordinate(coordinate2.i - 1, coordinate2.j + 1)) {
                    coordinate2.i--;
                    coordinate2.j++;
                    return true;
                }
            }
            return false;
        }

        boolean spinClockwiseBaseOnCoordinate2() {
            if (coordinate1.i == coordinate2.i) {
                if (validateCoordinate(coordinate1.i - 1, coordinate1.j) && validateCoordinate(coordinate1.i - 1, coordinate1.j + 1)) {
                    coordinate1.i--;
                    coordinate1.j++;
                    return true;
                }
            } else {
                if (validateCoordinate(coordinate1.i, coordinate1.j + 1) && validateCoordinate(coordinate1.i + 1, coordinate1.j + 1)) {
                    coordinate1.i++;
                    coordinate1.j++;
                    return true;
                }
            }
            return false;
        }

        boolean spinAntiClockwiseBaseOnCoordinate2() {
            if (coordinate1.i == coordinate2.i) {
                if (validateCoordinate(coordinate1.i - 1, coordinate1.j) && validateCoordinate(coordinate1.i - 1, coordinate1.j + 1)) {
                    coordinate1.i--;
                    coordinate1.j++;
                    return true;
                }
            } else {
                if (validateCoordinate(coordinate1.i, coordinate1.j - 1) && validateCoordinate(coordinate1.i + 1, coordinate1.j - 1)) {
                    coordinate1.i++;
                    coordinate1.j--;
                    return true;
                }
            }
            return false;
        }

        void arrangeCoordinates() {
            if (coordinate1.i == coordinate2.i && coordinate1.j > coordinate2.j) {
                Coordinate tmpCoordinate = this.coordinate1;
                this.coordinate1 = coordinate2;
                this.coordinate2 = tmpCoordinate;
            } else if (coordinate1.j == coordinate2.j && coordinate1.i > coordinate2.i) {
                Coordinate tmpCoordinate = this.coordinate1;
                this.coordinate1 = coordinate2;
                this.coordinate2 = tmpCoordinate;
            }

            System.out.println(coordinate1.i + "," + coordinate1.j + " / " + coordinate2.i + "," + coordinate2.j);
        }

        boolean isOnGoal() {
            return (coordinate1.i == board.length - 1 && coordinate1.j == board[0].length - 1)
                    || (coordinate2.i == board.length - 1 && coordinate2.j == board[0].length - 1);
        }

        boolean validateCoordinate(final int i, final int j) {
            return (board.length > i - 1 && i - 1 >= 0) && (board[0].length + 1 > j - 1 && j - 1 >= 0) && (board[i - 1][j - 1] != 1);
        }
    }

    private int minMovementCount = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        Robot robot = new Robot(board, new Robot.Coordinate(1, 1), new Robot.Coordinate(1, 2));
        robotMovement(robot, 0);
        return minMovementCount;
    }

    private void robotMovement(Robot robot, int moveMentCount) {
        if (robot.moveToTop()) {
            move(robot, moveMentCount);
        } else if (robot.moveToDown()) {
            move(robot, moveMentCount);
        } else if (robot.moveToLeft()) {
            move(robot, moveMentCount);
        } else if (robot.moveToRight()) {
            move(robot, moveMentCount);
        } else if (robot.spinClockwiseBaseOnCoordinate1()) {
            move(robot, moveMentCount);
        } else if (robot.spinClockwiseBaseOnCoordinate2()) {
            move(robot, moveMentCount);
        } else if (robot.spinAntiClockwiseBaseOnCoordinate1()) {
            move(robot, moveMentCount);
        } else if (robot.spinAntiClockwiseBaseOnCoordinate2()) {
            move(robot, moveMentCount);
        }
    }

    private void move(final Robot robot, int movementCount) {
        robot.arrangeCoordinates();
        movementCount++;
        if (robot.isOnGoal()) {
            minMovementCount = Math.min(minMovementCount, movementCount);
        } else {
            robotMovement(robot, movementCount);
        }
    }
}

public class P7 {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0}};

        Solution solution = new Solution();
        System.out.println("solution.solution(board) = " + solution.solution(board));
    }
}
