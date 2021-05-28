package exercise.programmers.p42861;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

//0. 간선데이터를 비용이 낮은 것을 우선으로 정렬한다.
//1. 모든 간선을 확인하면서 사이클을 형성하는지 확인한다.
//2. 사이클을 형성하지 않으면 포함한다.
class Solution {
    static class Node {
        private final List<Node> nodes;
        private final int index;
        private int rootIndex;

        public Node(int index, List<Node> nodes) {
            this.index = index;
            this.nodes = nodes;
            rootIndex = index;
        }

        public int findRoot() {
            if (index == rootIndex) {
                return index;
            }

            rootIndex = nodes.get(rootIndex).findRoot();
            return rootIndex;
        }

        public boolean isSameRoot(Node node) {
            return findRoot() == node.findRoot();
        }

        public void unionRoot(Node node) {
            if (isSameRoot(node)) {
                return;
            }

            if (rootIndex < node.rootIndex) {
                nodes.get(node.rootIndex).rootIndex = rootIndex;
                return;
            }

            if (node.rootIndex < rootIndex) {
                nodes.get(rootIndex).rootIndex = node.rootIndex;
                return;
            }

            throw new IllegalStateException("union 실패");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node node = (Node) o;

            return index == node.index;
        }

        @Override
        public int hashCode() {
            return index;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", rootIndex=" + rootIndex +
                    '}';
        }
    }

    static class Edge implements Comparable<Edge> {
        private final Node node1;
        private final Node node2;
        private final int cost;

        public Edge(Node node1, Node node2, int cost) {
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Edge)) return false;

            Edge edge = (Edge) o;

            if (cost != edge.cost) return false;
            if (!node1.equals(edge.node1)) return false;
            return node2.equals(edge.node2);
        }

        @Override
        public int hashCode() {
            int result = node1.hashCode();
            result = 31 * result + node2.hashCode();
            result = 31 * result + cost;
            return result;
        }

        @Override
        public int compareTo(Edge o) {
            if (cost != o.cost) {
                return Integer.compare(cost, o.cost);
            }

            if (node1.index != o.node1.index) {
                return Integer.compare(node1.index, o.node1.index);
            }

            return Integer.compare(node2.index, o.node2.index);
        }
    }

    public int solution(int n, int[][] costs) {
        List<Node> nodes = getNodes(n);

        TreeSet<Edge> edges = getEdges(costs, nodes);

        int minCost = 0;
        for (Edge edge : edges) {
            Node node1 = edge.node1;
            Node node2 = edge.node2;
            if (!node1.isSameRoot(node2)) {
                node1.unionRoot(node2);
                minCost += edge.cost;
            }
        }

        return minCost;
    }

    private TreeSet<Edge> getEdges(int[][] costs, List<Node> nodes) {
        TreeSet<Edge> edges = new TreeSet<>();
        for (int[] cost : costs) {
            final int fromIndex = cost[0];
            final int toIndex = cost[1];
            Node from = nodes.get(fromIndex);
            Node to = nodes.get(toIndex);
            edges.add(new Edge(from, to, cost[2]));
        }
        return edges;
    }

    private List<Node> getNodes(int n) {
        List<Node> nodes = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i, nodes));
        }
        return nodes;
    }
}

public class P42861 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}})).isEqualTo(4);
        assertThat(solution.solution(5, new int[][]{{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}})).isEqualTo(15);

        out.println("섬 연결하기" + " success!");
    }
}
