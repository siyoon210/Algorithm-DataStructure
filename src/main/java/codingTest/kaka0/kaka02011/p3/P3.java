package codingTest.kaka0.kaka02011.p3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 스택 오버 플로우....... 음..........
 */
class Solution {
    private static class Coordinate implements Comparable<Coordinate> {
        private final int i;
        private final int j;

        public Coordinate(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinate)) return false;

            Coordinate that = (Coordinate) o;

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
        public int compareTo(Coordinate o) {
            if (i != o.i) {
                return Integer.compare(i, o.i);
            }

            return Integer.compare(j, o.j);
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    private static class Node {
        private final Map<Coordinate, Node> nodes;
        private final Coordinate coordinate;
        private Coordinate rootCoordinate;
        private final char value;
        private boolean filled;

        public Node(Map<Coordinate, Node> nodes, int i, int j, char value) {
            this.nodes = nodes;
            this.coordinate = new Coordinate(i, j);
            this.rootCoordinate = this.coordinate;
            this.value = value;
            filled = false;
        }

        private Coordinate findRoot() {
            if (!coordinate.equals(rootCoordinate)) {
                rootCoordinate = nodes.get(rootCoordinate).findRoot();
            }

            return rootCoordinate;
        }

        private boolean isSameRoot(Node node) {
            return findRoot().equals(node.findRoot());
        }

        private void unionRoot(Node node) {
            if (isSameRoot(node)) {
                return;
            }

            int compareTo = rootCoordinate.compareTo(node.rootCoordinate);

            if (compareTo < 0) {
                nodes.get(node.rootCoordinate).rootCoordinate = rootCoordinate;
                return;
            }

            if (compareTo > 0) {
                nodes.get(rootCoordinate).rootCoordinate = node.rootCoordinate;
                return;
            }

            throw new IllegalStateException("union 할때 compareTo 값이 0이면 안됨");
        }

        private boolean isFilled() {
            return filled;
        }

        private void fillNode() {
            filled = true;
        }

        private boolean isSameValue(Node node) {
            return value == node.value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "coordinate=" + coordinate +
                    ", rootCoordinate=" + rootCoordinate +
                    ", value=" + value +
                    ", filled=" + filled +
                    '}';
        }
    }

    public static int solution(List<String> arr) {
        int count = 0;
        Map<Coordinate, Node> coordinateNodeMap = initCoordinateNodeMap(arr);

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).length(); j++) {
                Node currNode = coordinateNodeMap.get(new Coordinate(i, j));
                Node upNode = coordinateNodeMap.get(new Coordinate(i - 1, j));
                Node leftNode = coordinateNodeMap.get(new Coordinate(i, j - 1));
                boolean upFilled = false;
                boolean leftFilled = false;

                currNode.fillNode();

                if (upNode != null && currNode.isSameValue(upNode)) {
                    upFilled = true;
                }

                if (leftNode != null && currNode.isSameValue(leftNode)) {
                    leftFilled = true;
                }

                if (upFilled && leftFilled) {
                    if (!leftNode.isSameRoot(upNode)) {
                        leftNode.unionRoot(upNode);
                        count--;
                    }
                    currNode.unionRoot(leftNode);
                }

                if (upFilled && !leftFilled) {
                    currNode.unionRoot(upNode);
                }

                if (!upFilled && leftFilled) {
                    currNode.unionRoot(leftNode);
                }

                if (!upFilled && !leftFilled) {
                    count++;
                }
            }
        }

        return count;
    }

    private static Map<Coordinate, Node> initCoordinateNodeMap(List<String> arr) {
        Map<Coordinate, Node> coordinateNodeMap = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            String str = arr.get(i);
            for (int j = 0; j < str.length(); j++) {
                coordinateNodeMap.put(new Coordinate(i, j), new Node(coordinateNodeMap, i, j, str.charAt(j)));
            }
        }
        return coordinateNodeMap;
    }
}

public class P3 {
    public static void main(String[] args) {
        assertThat(Solution.solution(Arrays.asList(
                "aaaba",
                "ababa",
                "aaaca"))).isEqualTo(5);

        assertThat(Solution.solution(Arrays.asList(
                "bbba",
                "abba",
                "acaa",
                "aaac"))).isEqualTo(4);

        StringBuilder sb = new StringBuilder();
        final int length = 50;
        for (int i = 0; i < length; i++) {
            sb.append("a");
        }
        final String str = sb.toString();

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            strings.add(str);
        }

        assertThat(Solution.solution(strings)).isEqualTo(1);

        out.println("p3" + " success!");
    }
}
