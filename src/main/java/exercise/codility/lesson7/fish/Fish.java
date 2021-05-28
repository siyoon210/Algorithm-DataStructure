package exercise.codility.lesson7.fish;

import java.util.Stack;

class Solution {
    private enum Direction {
        UPSTREAM(0), DOWNSTREAM(1);
        private final int intValue;

        Direction(int intValue) {
            this.intValue = intValue;
        }
    }

    private class Fish {
        private int size;
        private Direction direction;

        Fish(int size, int direction) {
            this.size = size;
            if (direction == Direction.UPSTREAM.intValue) {
                this.direction = Direction.UPSTREAM;
            } else {
                this.direction = Direction.DOWNSTREAM;
            }
        }
    }

    public int solution(int[] A, int[] B) {
        Stack<Fish> fishStack = new Stack<>();
        Stack<Fish> tmpFishStack = new Stack<>();
        int countOfaliveFishes = 0;

        for (int i = A.length - 1; i >= 0; i--) {
            fishStack.push(new Fish(A[i], B[i]));
        }

        while (!fishStack.empty()) {
            Fish pop = fishStack.pop();
            //1. 위쪽 방향이면
            //1-1. tmp스택이 비어있으면 count++;
            //1-2. tmp스택이 비어있지 않으면 tmpPop과 싸운다.
                //1-2-1. 싸워서 pop이 이기면 count++;
                //1-2-2. 싸워서 tmpPop이 이기면 tmpPop을 푸쉬한다. <끝>

            //2. 아래쪽 방향이면
            //2-1. 스택이 비어있으면 count++;
            //2-2. 스택이 비어있지 않으면 peek
            //2-2-1. peek의 방향이 아래쪽이면 pop을 tmp스택에 넣는다. <끝>
            //2-2-2. peek의 방향이 위쪽이면 싸운다.
                //2-2-2-1. 싸워서 pop이 이기면 pop하고 다시 pop을 푸쉬한다.<끝>
                //2-2-2-2. 싸워서 peek이 이기면 <끝>

            if (pop.direction == Direction.UPSTREAM) {
                if (tmpFishStack.empty()) {
                    countOfaliveFishes++;
                } else {
                    Fish tmpPop = tmpFishStack.pop();
                    if (pop.size > tmpPop.size) {
                        countOfaliveFishes++;
                    } else {
                        fishStack.push(tmpPop);
                    }
                }
            } else {
                if (fishStack.empty()) {
                    countOfaliveFishes++;
                } else {
                    Fish peek = fishStack.peek();
                    if (peek.direction == Direction.DOWNSTREAM) {
                        tmpFishStack.push(pop);
                    } else {
                        if (pop.size > peek.size) {
                            fishStack.pop();
                            fishStack.push(pop);
                        }
                    }
                }
            }
        }

        return countOfaliveFishes + tmpFishStack.size();
    }
}

public class Fish {
    public static void main(String[] args) {
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 0, 0, 0};

        Solution solution = new Solution();
        System.out.println(solution.solution(A, B));
    }
}
