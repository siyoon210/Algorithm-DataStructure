package exercise.leetcode.p797;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    private static class Node {
        private int index;
        private List<Node> adjacentNodes;

        private Node(int index) {
            this.index = index;
            this.adjacentNodes = new ArrayList<>();
        }

        private void addAdjacentNode(Node node) {
            adjacentNodes.add(node);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> lists = new ArrayList<>();

        List<Node> nodes = initNodes(graph);

        dfs(lists, nodes, new ArrayList<>(), nodes.get(0));

        return lists;
    }

    private void dfs(List<List<Integer>> lists, List<Node> nodes, List<Integer> path, Node currNode) {
        path.add(currNode.index);

        if (currNode.index == nodes.size() - 1) {
            lists.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        for (Node adjacentNode : currNode.adjacentNodes) {
            dfs(lists, nodes, path, adjacentNode);
        }

        path.remove(path.size() - 1);
    }

    private List<Node> initNodes(int[][] graph) {
        List<Node> nodes = new ArrayList<>(graph.length);
        for (int i = 0; i < graph.length; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                nodes.get(i).addAdjacentNode(nodes.get(graph[i][j]));
            }
        }
        return nodes;
    }
}

public class P797 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}})).isEqualTo(
                Arrays.asList(
                        Arrays.asList(0, 1, 3),
                        Arrays.asList(0, 2, 3)
                )
        );

        out.println("p797" + " success!");
    }
}
