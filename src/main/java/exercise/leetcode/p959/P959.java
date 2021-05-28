package exercise.leetcode.p959;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    private static class Node {
        private final List<Node> nodeList;
        private final int index;
        private int rootNodeIndex;
        private final Set<Node> adjacentNodes;

        private Node(List<Node> nodeList, int index) {
            this.nodeList = nodeList;
            this.index = index;
            this.rootNodeIndex = index;
            this.adjacentNodes = new HashSet<>();
        }

        private int findRoot() {
            if (index == rootNodeIndex) {
                return index;
            }

            rootNodeIndex = nodeList.get(rootNodeIndex).findRoot();
            return rootNodeIndex;
        }

        private void addAdjacentNode(Node node) {
            adjacentNodes.add(node);
        }

        private boolean isSameRoot(Node node) {
            return findRoot() == node.findRoot();
        }

        private void unionRoot(Node node) {
            if (rootNodeIndex < node.rootNodeIndex) {
                nodeList.get(node.rootNodeIndex).rootNodeIndex = rootNodeIndex;
                return;
            }

            if (node.rootNodeIndex < rootNodeIndex) {
                nodeList.get(rootNodeIndex).rootNodeIndex = node.rootNodeIndex;
                return;
            }

            throw new IllegalStateException();
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
    }

    public int regionsBySlashes(String[] grid) {
        List<Node> nodeList = initNodeList(grid);
        Node[][] nodeArray = initNodes(grid, nodeList);
        return countSpaceCount(nodeArray);
    }

    private int countSpaceCount(Node[][] nodeArray) {
        int spaceCount = 0;
        for (Node[] nodes : nodeArray) {
            for (Node node : nodes) {
                for (Node adjacentNode : node.adjacentNodes) {
                    if (node.isSameRoot(adjacentNode)) {
                        spaceCount++;
                    } else {
                        node.unionRoot(adjacentNode);
                    }
                }
            }
        }
        return spaceCount;
    }

    private Node[][] initNodes(String[] grid, List<Node> nodeList) {
        Node[][] nodeArray = initNodeArray(grid, nodeList);
        setOutsideLineToAdjacentNodes(nodeArray);
        setAdjacentNodes(grid, nodeArray);
        return nodeArray;
    }

    private List<Node> initNodeList(String[] grid) {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < (grid.length + 1) * (grid.length + 1); i++) {
            nodeList.add(new Node(nodeList, i));
        }
        return nodeList;
    }

    private void setOutsideLineToAdjacentNodes(Node[][] nodeArray) {
        for (int i = 0; i < nodeArray.length - 1; i++) {
            //위
            nodeArray[0][i].addAdjacentNode(nodeArray[0][i + 1]);
            //왼쪽
            nodeArray[i][0].addAdjacentNode(nodeArray[i + 1][0]);
            //오른쪽
            nodeArray[i][nodeArray.length - 1].addAdjacentNode(nodeArray[i + 1][nodeArray.length - 1]);
            //아래
            nodeArray[nodeArray.length - 1][i].addAdjacentNode(nodeArray[nodeArray.length - 1][i + 1]);
        }
    }

    private void setAdjacentNodes(String[] grid, Node[][] nodeArray) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                final char c = grid[i].charAt(j);

                if (c == '/') {
                    nodeArray[i][j + 1].addAdjacentNode(nodeArray[i + 1][j]);
                    continue;
                }

                if (c == '\\') {
                    nodeArray[i][j].addAdjacentNode(nodeArray[i + 1][j + 1]);
                }
            }
        }
    }

    private Node[][] initNodeArray(String[] grid, List<Node> nodeList) {
        Node[][] nodeArray = new Node[grid.length + 1][grid.length + 1];
        int index = 0;
        for (int i = 0; i < nodeArray.length; i++) {
            for (int j = 0; j < nodeArray[i].length; j++) {
                nodeArray[i][j] = nodeList.get(index++);
            }
        }
        return nodeArray;
    }
}

public class P959 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.regionsBySlashes(new String[]{" /", "/ "})).isEqualTo(2);
        assertThat(solution.regionsBySlashes(new String[]{" /", "  "})).isEqualTo(1);
        assertThat(solution.regionsBySlashes(new String[]{"\\/", "/\\"})).isEqualTo(4);
        assertThat(solution.regionsBySlashes(new String[]{"/\\", "\\/"})).isEqualTo(5);
        assertThat(solution.regionsBySlashes(new String[]{"//", "/ "})).isEqualTo(3);
        assertThat(solution.regionsBySlashes(new String[]{" /\\", " \\/", "\\  "})).isEqualTo(4);
        assertThat(solution.regionsBySlashes(new String[]{"\\/\\ ", " /\\/", " \\/ ", "/ / "})).isEqualTo(3);
        assertThat(solution.regionsBySlashes(new String[]{"\\/\\\\ "," \\//\\","/\\///"," \\/\\\\","\\/\\/ "})).isEqualTo(9);

        out.println("p959" + " success!");
    }
}
