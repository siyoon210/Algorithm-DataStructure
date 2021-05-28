package exercise.leetcode.p743;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    static class Node implements Comparable<Node> {
        int index;
        int minPathCost = Integer.MAX_VALUE;
        boolean visited;
        Map<Node, Integer> adjacentNodes = new TreeMap<>();

        public Node(int index) {
            this.index = index;
        }

        void addAdjacentNode(Node node, int pathCost) {
            adjacentNodes.put(node, pathCost);
        }

        @Override
        public int compareTo(Node o) {
            if (minPathCost != o.minPathCost) {
                return Integer.compare(minPathCost, o.minPathCost);
            }

            return Integer.compare(index, o.index);
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        List<Node> nodes = initNodes(times, N);

        calcMinPathCost(K, nodes);

        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            if (nodes.get(i).minPathCost == Integer.MAX_VALUE) {
                return -1;
            }
            answer = Math.max(answer, nodes.get(i).minPathCost);
        }

        return answer == 0 ? -1 : answer;
    }

    private void calcMinPathCost(int K, List<Node> nodes) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        nodes.get(K).minPathCost = 0;
        priorityQueue.add(nodes.get(K));

        while (!priorityQueue.isEmpty()) {
            final Node node = priorityQueue.poll();

            if (node.visited) {
                continue;
            }

            for (Map.Entry<Node, Integer> entry : node.adjacentNodes.entrySet()) {
                final Node adjacentNode = entry.getKey();
                final Integer cost = entry.getValue();
                if (adjacentNode.visited) {
                    continue;
                }

                if (node.minPathCost + cost < adjacentNode.minPathCost) {
                    adjacentNode.minPathCost = node.minPathCost + cost;
                    priorityQueue.add(adjacentNode);
                }
            }

            node.visited = true;
        }
    }

    private List<Node> initNodes(int[][] times, int N) {
        List<Node> nodes = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            nodes.add(new Node(i));
        }

        for (int[] time : times) {
            nodes.get(time[0]).addAdjacentNode(nodes.get(time[1]), time[2]);
        }
        return nodes;
    }
}

public class P743 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2)).isEqualTo(2);
        assertThat(solution.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2)).isEqualTo(-1);
        assertThat(solution.networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 1}}, 3, 2)).isEqualTo(-1);

        out.println("P743" + " success!");
    }
}
