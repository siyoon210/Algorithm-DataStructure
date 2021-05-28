package codingTest.programmers.remotejobpair202004.p2;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    static class Robot {
        enum Direction {
            UP(-1, 0, "LEFT", "RIGHT"),
            DOWN(1, 0, "RIGHT", "LEFT"),
            LEFT(0, -1, "DOWN", "UP"),
            RIGHT(0, 1, "UP", "DOWN");

            private final int r, c;
            private final String rotateLeft;
            private final String rotateRight;

            Direction(int r, int c, String rotateLeft, String rotateRight) {
                this.r = r;
                this.c = c;
                this.rotateLeft = rotateLeft;
                this.rotateRight = rotateRight;
            }

            private Direction rotateLeft() {
                return Direction.valueOf(rotateLeft);
            }

            private Direction rotateRight() {
                return Direction.valueOf(rotateRight);
            }
        }

        private final int[][] office;
        private int r, c;
        private int cleanedDust;
        private Direction direction;

        public Robot(int[][] office, int r, int c) {
            this.office = office;
            this.r = r;
            this.c = c;
            this.cleanedDust = 0;
            this.direction = Direction.UP;
            clean();
        }

        public void doAction(String move) {
            switch (move) {
                case "go":
                    go();
                    clean();
                    break;
                case "left":
                    left();
                    break;
                case "right":
                    right();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        private void go() {
            int forwardR = this.r + this.direction.r;
            int forwardC = this.c + this.direction.c;

            try {
                final int i = office[forwardR][forwardC];
                if (i == -1) {
                    return;
                }
                this.r = forwardR;
                this.c = forwardC;
            } catch (IndexOutOfBoundsException ignored) {
            }
        }

        private void left() {
            this.direction = this.direction.rotateLeft();
        }

        private void right() {
            this.direction = this.direction.rotateRight();
        }

        private void clean() {
            cleanedDust += office[r][c];
            office[r][c] = 0;
        }
    }

    public int solution(int[][] office, int r, int c, String[] move) {
        final Robot robot = new Robot(office, r, c);
        for (String m : move) {
            robot.doAction(m);
        }
        return robot.cleanedDust;
    }
}

public class P2 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new int[][]{{5, -1, 4}, {6, 3, -1}, {2, -1, 1}}, 1, 0, new String[]{"go", "go", "right", "go", "right", "go", "left", "go"})).isEqualTo(14);

        out.println("remo P2" + " success!");
    }
}
