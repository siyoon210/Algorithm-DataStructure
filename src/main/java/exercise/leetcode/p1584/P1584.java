package exercise.leetcode.p1584;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    private static class Node {
        private static class Coordinate implements Comparable<Coordinate> {
            private final int x;
            private final int y;

            public Coordinate(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Coordinate)) return false;

                Coordinate that = (Coordinate) o;

                if (x != that.x) return false;
                return y == that.y;
            }

            @Override
            public int hashCode() {
                int result = x;
                result = 31 * result + y;
                return result;
            }

            @Override
            public int compareTo(Coordinate o) {
                if (x != o.x) {
                    return Integer.compare(x, o.x);
                }

                return Integer.compare(y, o.y);
            }

            @Override
            public String toString() {
                return "Coordinate{" +
                        "x=" + x +
                        ", y=" + y +
                        '}';
            }
        }

        private static final Map<Coordinate, Node> MAP = new LinkedHashMap<>();
        private final Coordinate coordinate;
        private Node root;

        private Node(int x, int y) {
            this.coordinate = new Coordinate(x, y);
            this.root = this;
        }

        private Node findRoot() {
            if (!coordinate.equals(root.coordinate)) {
                root = MAP.get(root.coordinate).findRoot();
            }

            return root;
        }

        private boolean isSameSet(Node node) {
            return findRoot().equals(node.findRoot());
        }

        private void unionSet(Node node) {
            if (coordinate.compareTo(node.coordinate) < 0) {
                MAP.get(node.root.coordinate).root = root;
                return;
            }

            if (coordinate.compareTo(node.coordinate) > 0) {
                MAP.get(root.coordinate).root = node.root;
                return;
            }

            throw new RuntimeException("same coordinate!" + coordinate);
        }
    }

    private static class Edge implements Comparable<Edge>{
        private static final List<Edge> LIST = new ArrayList<>();
        private final Node from;
        private final Node to;
        private final int distance;

        public Edge(Node from, Node to) {
            this.from = from;
            this.to = to;
            distance = Math.abs(from.coordinate.x - to.coordinate.x) + Math.abs(from.coordinate.y - to.coordinate.y);

            if (distance == 0) {
                throw new RuntimeException("distance can not be zero(0).");
            }
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(distance, o.distance);
        }
    }

    public int minCostConnectPoints(int[][] points) {
        initNodes(points);
        initEdges();
        return calcMinPathDistance();
    }

    private int calcMinPathDistance() {
        int answer = 0;
        for (Edge edge : Edge.LIST) {
            Node from = edge.from;
            Node to = edge.to;
            if (from.isSameSet(to)) {
                continue;
            }

            from.unionSet(to);
            answer += edge.distance;
        }
        return answer;
    }

    private void initEdges() {
        Edge.LIST.clear();
        for (Node.Coordinate from : Node.MAP.keySet()) {
            for (Node.Coordinate to : Node.MAP.keySet()) {
                if (from.equals(to)) {
                    continue;
                }

                if (from.compareTo(to) > 0) {
                    continue;
                }

                Edge.LIST.add(new Edge(Node.MAP.get(from), Node.MAP.get(to)));
            }
        }

        Collections.sort(Edge.LIST);
    }

    private void initNodes(int[][] points) {
        Node.MAP.clear();
        for (int[] point : points) {
            Node node = new Node(point[0], point[1]);
            Node.MAP.put(node.coordinate, node);
        }
    }
}

public class P1584 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}})).isEqualTo(20);

        out.println("p1584" + " success!");
    }

}
