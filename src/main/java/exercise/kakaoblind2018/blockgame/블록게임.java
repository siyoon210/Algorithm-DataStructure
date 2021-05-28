package exercise.kakaoblind2018.blockgame;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42894
 * 1. 주어진 보드판으로 블록 객체들을 생성한다.
 * 1-1. 블록들은 자신이 부셔질 수 있는 모양인지 아닌지 미리 계산해둔다.
 * 1-2. 블록들은 어떤 좌표가 채워져야 자신이 부셔지는지 미리 계산해둔다. (부셔지는 좌표)
 * 2. 검은색 블록을 떨어진다면 어떤 좌표에 떨어지게 되는지 계산해둔다. (포인터)
 * 3. 이제 부셔질 수 있는 블록들만으로 아래과정을 반복해서 검사한다.
 * 3-1. (부셔지는 좌표)가 (포인터)와 같거나 그 위쪽에 있는가?
 * 3-2. 맞다면 해당 블록은 부신다.
 * 3-2-1. 블록자리는 빈칸으로 만든다.
 * 3-2-2. (포인터)의 위치를 수정한다.
 * 3-3-3. (정답 카운터)를 증가시킨다.
 * 3-3. 만약 for문을 모두 돌았다면 (카운터)를 반환한다.
 */
class Block {
    Index index;
    Set<Coordinate> coordinates;
    boolean breakable;
    Set<Coordinate> coordinatesToBeRectangle;

    Block(final Index index) {
        this.index = index;
        coordinates = new HashSet<>();
        coordinatesToBeRectangle = new HashSet<>();
    }

    boolean addCoordinates(Coordinate coordinate) {
        if (coordinates.size() >= 4 && !coordinates.contains(coordinate)) {
            throw new RuntimeException("좌표를 4개 이상 갖을 순 없습니다. - index : " + index.value);
        }

        return coordinates.add(coordinate);
    }

    void determineSelfStatus(Set<Shape> defaultShapes) {
        Set<Coordinate> adjustedCoordinates = getZeroAdjustedCoordinates();
        determineBreakable(defaultShapes, adjustedCoordinates);
    }

    private void determineBreakable(final Set<Shape> defaultShapes, final Set<Coordinate> adjustedCoordinates) {
        Coordinate minCoordinates = getMinCoordinate();

        for (final Shape defaultShape : defaultShapes) {
            if (defaultShape.coordinates.equals(adjustedCoordinates)) {
                determineBreakable(minCoordinates, defaultShape);
            }
        }
    }

    private void determineBreakable(final Coordinate minCoordinates, final Shape defaultShape) {
        if (this.breakable = defaultShape.breakable) {
            setCoordinatesToBeRectangle(minCoordinates, defaultShape);
        }
    }

    private void setCoordinatesToBeRectangle(final Coordinate minCoordinate, final Shape defaultShape) {
        for (final Coordinate coordinate : defaultShape.coordinatesToBeRectangle) {
            this.coordinatesToBeRectangle.add(new Coordinate(coordinate.i + minCoordinate.i, coordinate.j + minCoordinate.j));
        }
    }

    /**
     * 현재 블럭의 모양을 알아내기 위해서 0,0에 가장 가깝게 조정하기
     *
     * @return 조정된 좌표들을 반환
     */
    private Set<Coordinate> getZeroAdjustedCoordinates() {
        Coordinate minCoordinates = getMinCoordinate();

        Set<Coordinate> adjustedCoordinates = new HashSet<>();

        for (final Coordinate coordinate : coordinates) {
            adjustedCoordinates.add(new Coordinate(coordinate.i - minCoordinates.i, coordinate.j - minCoordinates.j));
        }
        return adjustedCoordinates;
    }

    private Coordinate getMinCoordinate() {
        Coordinate minCoordinates = new Coordinate(Solution.MAX_BOARD_SIZE, Solution.MAX_BOARD_SIZE);

        for (final Coordinate coordinate : coordinates) {
            minCoordinates.i = Math.min(minCoordinates.i, coordinate.i);
            minCoordinates.j = Math.min(minCoordinates.j, coordinate.j);
        }
        return minCoordinates;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Block block = (Block) o;

        return index.equals(block.index);

    }

    @Override
    public int hashCode() {
        return index.hashCode();
    }

    static class Shape {
        Set<Coordinate> coordinates;
        boolean breakable;
        Set<Coordinate> coordinatesToBeRectangle;

        Shape(final Set<Coordinate> coordinates, final boolean breakable, final Set<Coordinate> coordinatesToBeRectangle) {
            this.coordinates = coordinates;
            this.breakable = breakable;
            this.coordinatesToBeRectangle = coordinatesToBeRectangle;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Shape shape = (Shape) o;

            return coordinates.equals(shape.coordinates);

        }

        @Override
        public int hashCode() {
            return coordinates.hashCode();
        }
    }
}

class Coordinate {
    int i;
    int j;

    Coordinate(final int i, final int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Coordinate that = (Coordinate) o;

        if (i != that.i) return false;
        return j == that.j;

    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + j;
        return result;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}

class Index {
    int value;

    Index(final int value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Index index = (Index) o;

        return value == index.value;

    }

    @Override
    public int hashCode() {
        return value;
    }
}

class Solution {
    static final int MAX_BOARD_SIZE = 50;
    private Map<Integer, Coordinate> pointersBlackBlockWillBePlaced = new HashMap();
    private Set<Block.Shape> defaultShapes = new HashSet<>();
    private int answer = 0;
    private int[][] board;

    public int solution(int[][] board) {
        this.board = board;
        initDefaultShapes();
        final Map<Index, Block> indexBlockMap = initBlocks();



        while (true) {
            arrangePointers();
            if (hasBreakEvent(indexBlockMap)) {
                continue;
            }
            break;
        }

        return answer;
    }

    private void arrangePointers() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!isEmptyCoordinate(board[j][i])) {
                    pointersBlackBlockWillBePlaced.put(i, new Coordinate(i, j - 1));
                    break;
                } else if (j == board.length - 1) {
                    pointersBlackBlockWillBePlaced.put(i, new Coordinate(i, j));
                    break;
                }
            }
        }
    }

    private boolean hasBreakEvent(final Map<Index, Block> indexBlockMap) {
        for (final Map.Entry<Index, Block> indexBlockEntry : indexBlockMap.entrySet()) {
            final Block block = indexBlockEntry.getValue();
            if (block.breakable && isValidToBreak(block)) {
                answer++;
                breakBlock(block);
                indexBlockMap.remove(indexBlockEntry.getKey());
                return true;
            }
        }

        return false;
    }

    private void breakBlock(final Block block) {
        for (final Coordinate coordinate : block.coordinates) {
            board[coordinate.i][coordinate.j] = 0;
        }
    }

    private boolean isValidToBreak(Block block) {
        for (final Coordinate coordinate : block.coordinatesToBeRectangle) {
            final Coordinate pointerCoordinate = pointersBlackBlockWillBePlaced.get(coordinate.i);
            if (coordinate.j > pointerCoordinate.j) {
                return false;
            }
        }
        return true;
    }

    private void initDefaultShapes() {
        {//1-1
            Set<Coordinate> coordinates = new HashSet<>();
            coordinates.add(new Coordinate(0, 0));
            coordinates.add(new Coordinate(0, 1));
            coordinates.add(new Coordinate(0, 2));
            coordinates.add(new Coordinate(1, 2));
            defaultShapes.add(new Block.Shape(coordinates, false, null));
        }

        {//1-2
            Set<Coordinate> coordinates = new HashSet<>();
            coordinates.add(new Coordinate(0, 0));
            coordinates.add(new Coordinate(0, 1));
            coordinates.add(new Coordinate(1, 0));
            coordinates.add(new Coordinate(2, 0));
            defaultShapes.add(new Block.Shape(coordinates, false, null));
        }

        {//1-3
            Set<Coordinate> coordinates = new HashSet<>();
            coordinates.add(new Coordinate(0, 0));
            coordinates.add(new Coordinate(1, 0));
            coordinates.add(new Coordinate(1, 1));
            coordinates.add(new Coordinate(1, 2));
            Set<Coordinate> coordinatesToBeRectangle = new HashSet<>();
            coordinatesToBeRectangle.add(new Coordinate(0, 1));
            coordinatesToBeRectangle.add(new Coordinate(0, 2));
            defaultShapes.add(new Block.Shape(coordinates, true, coordinatesToBeRectangle));
        }

        {//1-4
            Set<Coordinate> coordinates = new HashSet<>();
            coordinates.add(new Coordinate(0, 0));
            coordinates.add(new Coordinate(0, 1));
            coordinates.add(new Coordinate(0, 2));
            coordinates.add(new Coordinate(2, 0));
            Set<Coordinate> coordinatesToBeRectangle = new HashSet<>();
            coordinatesToBeRectangle.add(new Coordinate(0, 0));
            coordinatesToBeRectangle.add(new Coordinate(1, 2));
            defaultShapes.add(new Block.Shape(coordinates, true, coordinatesToBeRectangle));
        }

        {//2-1
            Set<Coordinate> coordinates = new HashSet<>();
            coordinates.add(new Coordinate(0, 0));
            coordinates.add(new Coordinate(0, 1));
            coordinates.add(new Coordinate(0, 2));
            coordinates.add(new Coordinate(1, 0));
            defaultShapes.add(new Block.Shape(coordinates, false, null));
        }

        {//2-2
            Set<Coordinate> coordinates = new HashSet<>();
            coordinates.add(new Coordinate(0, 0));
            coordinates.add(new Coordinate(1, 0));
            coordinates.add(new Coordinate(2, 0));
            coordinates.add(new Coordinate(2, 1));
            Set<Coordinate> coordinatesToBeRectangle = new HashSet<>();
            coordinatesToBeRectangle.add(new Coordinate(0, 1));
            coordinatesToBeRectangle.add(new Coordinate(1, 1));
            defaultShapes.add(new Block.Shape(coordinates, true, coordinatesToBeRectangle));
        }

        {//2-3
            Set<Coordinate> coordinates = new HashSet<>();
            coordinates.add(new Coordinate(0, 2));
            coordinates.add(new Coordinate(1, 0));
            coordinates.add(new Coordinate(1, 1));
            coordinates.add(new Coordinate(1, 2));
            Set<Coordinate> coordinatesToBeRectangle = new HashSet<>();
            coordinatesToBeRectangle.add(new Coordinate(0, 0));
            coordinatesToBeRectangle.add(new Coordinate(0, 1));
            defaultShapes.add(new Block.Shape(coordinates, true, coordinatesToBeRectangle));
        }

        {//2-4
            Set<Coordinate> coordinates = new HashSet<>();
            coordinates.add(new Coordinate(0, 0));
            coordinates.add(new Coordinate(0, 1));
            coordinates.add(new Coordinate(1, 1));
            coordinates.add(new Coordinate(1, 2));
            defaultShapes.add(new Block.Shape(coordinates, false, null));
        }

        {//3-1
            Set<Coordinate> coordinates = new HashSet<>();
            coordinates.add(new Coordinate(0, 1));
            coordinates.add(new Coordinate(1, 0));
            coordinates.add(new Coordinate(1, 1));
            coordinates.add(new Coordinate(1, 2));
            Set<Coordinate> coordinatesToBeRectangle = new HashSet<>();
            coordinatesToBeRectangle.add(new Coordinate(0, 0));
            coordinatesToBeRectangle.add(new Coordinate(0, 2));
            defaultShapes.add(new Block.Shape(coordinates, true, coordinatesToBeRectangle));
        }

        {//3-2
            Set<Coordinate> coordinates = new HashSet<>();
            coordinates.add(new Coordinate(0, 0));
            coordinates.add(new Coordinate(1, 0));
            coordinates.add(new Coordinate(1, 1));
            coordinates.add(new Coordinate(2, 0));
            defaultShapes.add(new Block.Shape(coordinates, false, null));
        }

        {//3-3
            Set<Coordinate> coordinates = new HashSet<>();
            coordinates.add(new Coordinate(0, 0));
            coordinates.add(new Coordinate(0, 1));
            coordinates.add(new Coordinate(0, 2));
            coordinates.add(new Coordinate(1, 1));
            defaultShapes.add(new Block.Shape(coordinates, false, null));
        }

        {//3-4
            Set<Coordinate> coordinates = new HashSet<>();
            coordinates.add(new Coordinate(0, 1));
            coordinates.add(new Coordinate(1, 0));
            coordinates.add(new Coordinate(1, 1));
            coordinates.add(new Coordinate(2, 1));
            defaultShapes.add(new Block.Shape(coordinates, false, null));
        }
    }

    private Map<Index, Block> initBlocks() {
        final Map<Index, Block> indexBlockMap = new HashMap<>();

        createBlocks(indexBlockMap);
        determineStatus(indexBlockMap);

        return indexBlockMap;
    }

    private void determineStatus(final Map<Index, Block> indexBlockMap) {
        indexBlockMap.forEach((k, v) -> v.determineSelfStatus(defaultShapes));
    }

    private void createBlocks(final Map<Index, Block> indexBlockMap) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (isEmptyCoordinate(board[i][j])) {
                    continue;
                }

                final Index index = new Index(board[i][j]);
                if (indexBlockMap.containsKey(index)) {
                    final Block block = indexBlockMap.get(index);
                    block.addCoordinates(new Coordinate(i, j));
                    continue;
                }

                final Block block = new Block(index);
                block.addCoordinates(new Coordinate(i, j));
                indexBlockMap.put(index, block);
            }
        }
    }

    private boolean isEmptyCoordinate(final int i) {
        return i == 0;
    }
}

public class 블록게임 {
    public static void main(String[] args) {
        int[][] board =
                {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 4, 0, 0, 0},
                        {0, 0, 0, 0, 0, 4, 4, 0, 0, 0},
                        {0, 0, 0, 0, 3, 0, 4, 0, 0, 0},
                        {0, 0, 0, 2, 3, 0, 0, 0, 5, 5},
                        {1, 2, 2, 2, 3, 3, 0, 0, 0, 5},
                        {1, 1, 1, 0, 0, 0, 0, 0, 0, 5}
                };

        Solution solutions = new Solution();

        System.out.println("solutions.solution(board) = " + solutions.solution(board));
    }
}
