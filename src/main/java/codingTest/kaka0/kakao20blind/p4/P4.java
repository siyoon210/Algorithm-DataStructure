package codingTest.kaka0.kakao20blind.p4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    static class Graph {
        private List<Node> nodes;
        private int startId;
        private int aId;
        private int bId;
        private List<Path> aPaths = new ArrayList<>();
        private List<Path> bPaths = new ArrayList<>();


        public Graph(int nodeSize, int s, int a, int b) {
            this.nodes = new ArrayList<>(nodeSize);

            for (int i = 0; i < nodeSize; i++) {
                nodes.add(i, new Node(i + 1));
            }

            this.startId = s;
            this.aId = a;
            this.bId = b;
        }

        public Node getNodeById(int id) {
            return nodes.get(id - 1);
        }

        private void addFare(int i, int j, int fare) {
            getNodeById(i).adjacentIdAndFare.put(j, fare);
            getNodeById(j).adjacentIdAndFare.put(i, fare);
        }

        private void traversal() {
            getNodeById(startId).traversal(startId, aId, bId, new ArrayList<Path>());
        }
    }

    static class Node {
        private int id;
        private Map<Integer, Integer> adjacentIdAndFare = new HashMap<>();
        private boolean isVisited;

        public Node(int id) {
            this.id = id;
        }

        public void traversal(int startId, int aId, int bId, List<Path> pathIds) {
            this.isVisited = true;

            for (Map.Entry<Integer, Integer> idAndFares : adjacentIdAndFare.entrySet()) {

            }

            this.isVisited = false;
        }
    }

    static class Path {
        private List<Integer> paths = new ArrayList<>();
        int totalFare = 0;

        public void addPath(int id, int fare) {
            paths.add(id);
            totalFare += fare;
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        Graph graph = intGraph(n, s, a, b, fares);
        graph.traversal();
        return answer;
    }

    private Graph intGraph(int n, int s, int a, int b, int[][] fares) {
        Graph graph = new Graph(n, s, a, b);

        for (int[] fare : fares) {
            graph.addFare(fare[0], fare[1], fare[2]);
        }
        return graph;
    }
}

public class P4 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(6, 4, 6, 2,
                new int[][]{
                        {4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24},
                        {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}
                }))
                .isEqualTo(82);

        out.println("p4" + " success!");
    }
}
