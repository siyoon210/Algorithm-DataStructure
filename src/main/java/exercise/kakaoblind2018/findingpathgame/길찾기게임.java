package exercise.kakaoblind2018.findingpathgame;

import java.util.*;

class Node implements Comparable<Node> {
    int id;
    private int x;
    private int y;
    private Node parent;
    Node leftChild;
    Node rightChild;
    private Integer leftLimited;
    private Integer rightLimited;

    Node(final int id, final int x, final int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.leftLimited = -1;
        this.rightLimited = 100_001;
    }

    boolean canBeLeftChild(Node parentCandidate) {
        if (parentCandidate.leftChild != null) {
            return false;
        }

        if (this.parent != null) {
            return false;
        }

        if (this.y >= parentCandidate.y) {
            return false;
        }

        if (this.x >= parentCandidate.x) {
            return false;
        }

        return parentCandidate.leftLimited < this.x && this.x < parentCandidate.rightLimited;
    }

    boolean canBeRightChild(Node parentCandidate) {
        if (parentCandidate.rightChild != null) {
            return false;
        }

        if (this.parent != null) {
            return false;
        }

        if (this.y >= parentCandidate.y) {
            return false;
        }

        if (this.x <= parentCandidate.x) {
            return false;
        }

        return parentCandidate.leftLimited < this.x && this.x < parentCandidate.rightLimited;
    }

    void setParentAsLeftChild(Node parent) {
        this.parent = parent;
        parent.leftChild = this;
        this.leftLimited = parent.leftLimited;
        this.rightLimited = parent.x;
    }

    void setParentAsRightChild(Node parent) {
        this.parent = parent;
        parent.rightChild = this;
        this.leftLimited = parent.x;
        this.rightLimited = parent.rightLimited;
    }

    @Override
    public int compareTo(final Node o) {
        final int i = y - o.y;
        if (i > 0) {
            return -1;
        } else if (i < 0) {
            return 1;
        }

        return x - o.x;
    }
}

class Solution {
    private List<Node> nodes;

    public int[][] solution(int[][] nodeinfo) {
        setTree(nodeinfo);
        int[] preOrderResult = getPreOrderResult();
        int[] postOrderResult = getPostOrderResult();

        return new int[][] {preOrderResult, postOrderResult};
    }

    private int[] getPostOrderResult() {
        List<Integer> postOrderResult = new ArrayList<>();
        final Node root = nodes.get(0);

        postOrderDfs(root, postOrderResult);

        int[] preOrderResultArray = new int[postOrderResult.size()];
        for (int i = 0; i < preOrderResultArray.length; i++) {
            preOrderResultArray[i] = postOrderResult.get(i);
        }

        return preOrderResultArray;
    }

    private void postOrderDfs(final Node node, final List<Integer> postOrderResult) {
        if (node.leftChild != null) {
            postOrderDfs(node.leftChild, postOrderResult);
        }

        if (node.rightChild != null) {
            postOrderDfs(node.rightChild, postOrderResult);
        }

        postOrderResult.add(node.id);
    }

    private int[] getPreOrderResult() {
        List<Integer> preOrderResult = new ArrayList<>();
        final Node root = nodes.get(0);

        preOrderDfs(root, preOrderResult);

        int[] preOrderResultArray = new int[preOrderResult.size()];
        for (int i = 0; i < preOrderResultArray.length; i++) {
            preOrderResultArray[i] = preOrderResult.get(i);
        }

        return preOrderResultArray;
    }

    private void preOrderDfs(Node node, List<Integer> preOrderResult) {
        preOrderResult.add(node.id);

        if (node.leftChild != null) {
            preOrderDfs(node.leftChild, preOrderResult);
        }

        if (node.rightChild != null) {
            preOrderDfs(node.rightChild, preOrderResult);
        }
    }

    private void setTree(final int[][] nodeinfo) {
        nodes = new ArrayList<>();

        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        Collections.sort(nodes);

        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                if (nodes.get(j).canBeLeftChild(nodes.get(i))) {
                    nodes.get(j).setParentAsLeftChild(nodes.get(i));
                }

                if (nodes.get(j).canBeRightChild(nodes.get(i))) {
                    nodes.get(j).setParentAsRightChild(nodes.get(i));
                }

                if (nodes.get(i).rightChild != null) {
                    break;
                }
            }
        }
    }
}

public class 길찾기게임 {
    public static void main(String[] args) {
        int[][] nodeinfo = {
                {5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}
        };

        Solution solution = new Solution();
        final int[][] answer = solution.solution(nodeinfo);

        for (final int[] ints : answer) {
            for (final int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}

