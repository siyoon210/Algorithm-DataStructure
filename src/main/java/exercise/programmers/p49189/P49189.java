package exercise.programmers.p49189;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int solution(int n, int[][] edges) {
        List<Node> nodes = initNodes(n, edges);

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(nodes.get(Node.START_NODE_INDEX));

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            if (node.isVisited()) {
                continue;
            }

            node.renewAdjacentNodesMinPath(priorityQueue);
            node.visit();
        }

        int max = 0;
        for (Node node : nodes) {
            max = Math.max(max, node.getMinPath());
        }

        int count = 0;
        for (Node node : nodes) {
            if (node.getMinPath() == max) {
                count++;
            }
        }

        return count;
    }

    private List<Node> initNodes(int n, int[][] edges) {
        List<Node> nodes = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            nodes.add(new Node(i));
        }

        for (int[] edge : edges) {
            int fromIndex = edge[0];
            int toIndex = edge[1];
            Node from = nodes.get(fromIndex);
            Node to = nodes.get(toIndex);

            from.addAdjacentNode(to);
            to.addAdjacentNode(from);
        }

        return nodes;
    }
}

class Node implements Comparable<Node> {
    public static final int START_NODE_INDEX = 1;
    private final int index;
    public final List<Node> adjacentNodes;
    private int minPath;
    private boolean visited;

    public Node(int index) {
        this.index = index;
        adjacentNodes = new ArrayList<>();
        minPath = initMinPath(index);
        visited = false;
    }

    private int initMinPath(int index) {
        if (index <= START_NODE_INDEX) {
            return 0;
        }
        return minPath = Integer.MAX_VALUE;
    }

    public void addAdjacentNode(Node node) {
        adjacentNodes.add(node);
    }

    public void renewAdjacentNodesMinPath(PriorityQueue<Node> priorityQueue) {
        for (Node adjacentNode : adjacentNodes) {
            if (adjacentNode.isVisited()) {
                continue;
            }

            if (minPath + 1 < adjacentNode.minPath) {
                adjacentNode.minPath = minPath + 1;
                priorityQueue.add(adjacentNode);
            }
        }
    }

    public void visit() {
        visited = true;
    }

    public boolean isVisited() {
        return visited;
    }

    public int getMinPath() {
        return minPath;
    }

    @Override
    public int compareTo(Node o) {
        if (minPath == o.minPath) {
            return Integer.compare(index, o.index);
        }

        return Integer.compare(minPath, o.minPath);
    }

    @Override
    public String toString() {
        return "Node{" +
                "index=" + index +
                ", minPath=" + minPath +
                ", visited=" + visited +
                '}';
    }
}

public class P49189 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}})).isEqualTo(3);
        assertThat(solution.solution(6, new int[][]{{1, 6}, {6, 2}, {6, 5}, {2, 4}, {5, 3}})).isEqualTo(2);

        out.println("p49189" + " success!");
    }
}
