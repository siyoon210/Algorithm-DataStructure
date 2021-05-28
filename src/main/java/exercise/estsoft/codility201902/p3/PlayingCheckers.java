package exercise.estsoft.codility201902.p3;

class Checkers {
    //1. 입력값이 문자열로 받기 때문에, 문자열을 직관적으로 다루기 위해서 이넘을 사용하여서 상수로써 다룬다.
    enum FieldStatus {
        WHITE_PAWN('O'), BLACK_PAWN('X'), EMPTY('.');
        private final char charValue;

        FieldStatus(char charValue) {
            this.charValue = charValue;
        }
    }

    //2. 주어진 입력값을 2차원 문자 배열로 만드는 필드와, 현재 하얀폰이 있는 좌표 x,y
    //그리고 가장 많이 잡아먹은 숫자를 세는 필드로 이루어진다.
    private char[][] board;
    private int coordinateOfWhitePawnX; //X좌표
    private int coordinateOfWhitePawnY; //Y좌표
    private int maxBeatenCount;

    Checkers(String[] B) {
        maxBeatenCount = 0;
        //3.
        setBoard(B);
    }

    //3. Checker 객체가 만들어지면서 입력 배열을 이용하여 바로 board 필드를 설정한다.
    private void setBoard(String[] B) {
        int boardSize = B.length;
        board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < B[i].toCharArray().length; j++) {
                board[i][j] = B[i].charAt(j);
                //4.
                setCoordinateOfWhitePawn(i, j);
            }
        }
    }

    //4. 보드판을 설정하던 중에 하얀폰에 해당하는 좌표라면, 따로 입력해둔다.
    private void setCoordinateOfWhitePawn(int i, int j) {
        if (board[i][j] == FieldStatus.WHITE_PAWN.charValue) {
            coordinateOfWhitePawnY = i;
            coordinateOfWhitePawnX = j;
        }
    }

    //5. 실질적으로 가장 많이 잡아먹은 숫자를 세기위해서 시작되는 메소드
    //하얀 폰은 좌측상단 혹은 우측 상단 대각선 방향으로만 움직일 수 있다.
    void calcMaxBeatenCount() {
        //WHITE_PAWN 의 위치를 기준으로 좌측 상단으로 탐색시
        moveUpLeft(getUpMovingCoordinate(coordinateOfWhitePawnY), getLeftMovingCoordinate(coordinateOfWhitePawnX), 0);
        //WHITE_PAWN 의 위치를 기준으로 우측 상단으로 탐색시
        moveUpRight(getUpMovingCoordinate(coordinateOfWhitePawnY), getRightMovingCoordinate(coordinateOfWhitePawnX), 0);
    }

    //6. 이런식으로 해둔 이유는 좌표 계산만 덜렁 있는 경우 나중에 코드를 보면 무슨 의도인지 알 수가 없고,
    //또한 만약에 당장 이동과 관련한 결과를 바꿔야 한다면, 이 메소드만 건들이면 된다.
    //6-1. 위쪽으로 가는 경우 Y 좌표계산
    private int getUpMovingCoordinate(int coordinateY) {
        return coordinateY - 1;
    }
    //6-2. 왼쪽으로 가는 경우 X 좌표계산
    private int getLeftMovingCoordinate(int coordinateX) {
        return coordinateX - 1;
    }
    //6-3. 오른쪽으로 가는 경우 X 좌표 계산
    private int getRightMovingCoordinate(int coordinateX) {
        return coordinateX + 1;
    }

    //7. 좌측 상단으로 말을 움직여보는 메소드다.
    private void moveUpLeft(int y, int x, int beatenCount) {
        //7-1. 좌측 상단으로 말을 움직이기 위해서는 조건이 필요한데,
        //7-2. 현재 필드에 검은폰이 있어야 하며, 같은 방향으로 다음 필드는 빈공간이여야 한다. 해당 경우를 확인한다.
        boolean isBlackPawnOnPresentField = checkField(y, x, FieldStatus.BLACK_PAWN);
        boolean isEmptyOnNextField = checkField(getUpMovingCoordinate(y), getLeftMovingCoordinate(x), FieldStatus.EMPTY);

        //이동할 수 있는 경우인지 확인하고 WHITE_PAWN 을 움직인다.
        if (isBlackPawnOnPresentField && isEmptyOnNextField) {
            y = getUpMovingCoordinate(y);
            x = getLeftMovingCoordinate(x);

            //7-3.이동이 가능한 경우였으니, 재귀적으로 또 잡어먹을 만한 폰이 있는지 확인한다.
            //beatenCount 를 하나 증가시킨다.
            moveUpLeft(getUpMovingCoordinate(y), getLeftMovingCoordinate(x), beatenCount + 1);
            moveUpRight(getUpMovingCoordinate(y), getRightMovingCoordinate(x), beatenCount + 1);
        } else {
            //7-4. 만약 이동이 불가능한 경우는 현재의 beatenCount 를 반환하고 끝낸다.
            this.maxBeatenCount = Math.max(maxBeatenCount, beatenCount);
        }
    }

    //8. 우측 상단으로 말을 움직여 보는 메소드다. 내부적으로는 방향만 다르지 7번과 같다.
    private void moveUpRight(int y, int x, int beatenCount) {
        boolean isBlackPawnOnPresentField = checkField(y, x, FieldStatus.BLACK_PAWN);
        boolean isEmptyOnNextField = checkField(getUpMovingCoordinate(y), getRightMovingCoordinate(x), FieldStatus.EMPTY);

        //이동할 수 있는 경우인지 확인하고 WHITE_PAWN 을 움직인다.
        if (isBlackPawnOnPresentField && isEmptyOnNextField) {
            y = getUpMovingCoordinate(y);
            x = getRightMovingCoordinate(x);

            moveUpLeft(getUpMovingCoordinate(y), getLeftMovingCoordinate(x), beatenCount + 1);
            moveUpRight(getUpMovingCoordinate(y), getRightMovingCoordinate(x), beatenCount + 1);
        } else {
            this.maxBeatenCount = Math.max(maxBeatenCount, beatenCount);
        }
    }

    //9. 7,8번에서 사용했었던 메소드로, 해당 좌표의 상태가 인자로 넘겨준 상태가 맞는지 아닌지 확인해준다.
    private boolean checkField(int y, int x, FieldStatus fieldStatus) {
        char fieldToCheck;

        try {
            fieldToCheck = board[y][x];
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }

        return fieldToCheck == fieldStatus.charValue;
    }

    int getMaxBeatenCount() {
        return maxBeatenCount;
    }
}

class Solution {
    public int solution(String[] B) {
        Checkers checkers = new Checkers(B);
        checkers.calcMaxBeatenCount();
        return checkers.getMaxBeatenCount();
    }
}

public class PlayingCheckers {
    public static void main(String[] args) {
//        String[] B = new String[6];
//        B[0] = "..X...";
//        B[1] = "......";
//        B[2] = "....X.";
//        B[3] = ".X....";
//        B[4] = "..X.X.";
//        B[5] = "...O..";

//        String[] B = new String[5];
//        B[0] = "X....";
//        B[1] = ".X...";
//        B[2] = "..O..";
//        B[3] = "...X.";
//        B[4] = ".....";

//        String[] B = new String[3];
//        B[0] = "...";
//        B[1] = ".XX";
//        B[2] = "O..";

//        String[] B = new String[7];
//        B[0] = "....X..";
//        B[1] = ".XX.X..";
//        B[2] = ".X..X..";
//        B[3] = ".X..X..";
//        B[4] = "..X.X..";
//        B[5] = "....X..";
//        B[6] = "...O...";

//        String[] B = new String[9];
//        B[0] = "......X";
//        B[1] = ".XX....";
//        B[2] = ".......";
//        B[3] = ".XX.X..";
//        B[4] = "..X.X..";
//        B[5] = "X.X.X..";
//        B[6] = ".......";
//        B[7] = "..X....";
//        B[8] = "...O...";

        String[] B = new String[1];
        B[0] = "O";

        Solution solution = new Solution();
        System.out.println(solution.solution(B));
    }
}
