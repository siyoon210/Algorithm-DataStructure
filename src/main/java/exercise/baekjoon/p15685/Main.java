package exercise.baekjoon.p15685;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countOfDragonCurve = sc.nextInt();
        int[][] dragonCurve = new int[countOfDragonCurve][4];

        for (int i = 0; i < countOfDragonCurve; i++) {
            for (int j = 0; j < 4; j++) {
                dragonCurve[i][j] = sc.nextInt();
            }
        }

        Solution solution = new Solution(dragonCurve);
        System.out.println(solution.calcCountOfSquare());
    }
}

class Solution {
    private int countOfSquare;
    private boolean[][] coordinatePlane;
    private int[][] dragonCurves;

    Solution(int[][] dragonCurve) {
        countOfSquare = 0;
        coordinatePlane = new boolean[10][10];
        this.dragonCurves = dragonCurve;
    }

    int calcCountOfSquare() {
        for (int[] dragonCurve : dragonCurves) {
            DragonCurve dc = new DragonCurve(dragonCurve[0], dragonCurve[1], dragonCurve[2], dragonCurve[3]);
            dc.makeDragonCurve();
        }

//        printPlane();
        return countOfSquare;
    }

    void printPlane() {
        for (int i = 0; i < coordinatePlane.length; i++) {
            for (int j = 0; j < coordinatePlane[0].length; j++) {
                System.out.print(coordinatePlane[i][j] ? 1 : 0);
            }
            System.out.println();
        }
    }

    class DragonCurve {
        Coordinate initCoordinate;
        Integer generation;
        Direction firstDirection;
        List<Direction> directionRecords;

        DragonCurve(int x, int y, int generation, int firstDirection) {
            this.initCoordinate = new Coordinate(x, y);
            this.generation = generation;
            this.firstDirection = Direction.convertIntToDirection(firstDirection);
            this.directionRecords = new ArrayList<>();
        }

        void makeDragonCurve() {
            firstMove();
            checkCoordinate(initCoordinate, 0);
        }

        private void firstMove() {
            directionRecords.add(firstDirection);
            checkCoordinate(initCoordinate);
            Direction direction = convertDirection(firstDirection);
            initCoordinate = adjustCoordinate(initCoordinate, direction);
            checkCoordinate(initCoordinate);
        }

        private void checkCoordinate(Coordinate cd) {
            coordinatePlane[cd.x][cd.y] = true;
            System.out.println(cd.x + "," + cd.y);
        }

        private void checkCoordinate(Coordinate coordinate, int presentGeneration) {
            if (presentGeneration > generation) {
                return;
            }

            for (int i = directionRecords.size() - 1; i >= 0; i--) {
                Direction direction = convertDirection(directionRecords.get(i));
                directionRecords.add(direction);
                Coordinate adjustCoordinate = adjustCoordinate(coordinate, direction);
                checkCoordinate(adjustCoordinate);
            }

            checkCoordinate(coordinate, presentGeneration + 1);
        }

        private Direction convertDirection(Direction direction) {
            switch (direction) {
                case RIGHT:
                    return Direction.UP;
                case UP:
                    return Direction.LEFT;
                case LEFT:
                    return Direction.DOWN;
                case DOWN:
                    return Direction.RIGHT;
                default:
                    return null;
            }
        }

        private Coordinate adjustCoordinate(Coordinate coordinate, Direction direction) {
            switch (direction) {
                case RIGHT:
                    coordinate.x += 1;
                    break;
                case UP:
                    coordinate.y -= 1;
                    break;
                case LEFT:
                    coordinate.x -= 1;
                    break;
                case DOWN:
                    coordinate.y += 1;
                    break;
                default:
                    break;
            }
            return coordinate;
        }
    }

    enum Direction {
        RIGHT(0), UP(1), LEFT(2), DOWN(3);
        int intValue;

        Direction(int intValue) {
            this.intValue = intValue;
        }

        public static Direction convertIntToDirection(int i) {
            switch (i) {
                case 0:
                    return Direction.RIGHT;
                case 1:
                    return Direction.UP;
                case 2:
                    return Direction.LEFT;
                case 3:
                    return Direction.DOWN;
                default:
                    return null;
            }
        }
    }

    class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}