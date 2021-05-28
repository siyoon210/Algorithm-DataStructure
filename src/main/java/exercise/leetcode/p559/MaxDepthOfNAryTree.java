package exercise.leetcode.p559;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

int depth = 0;
Queue<Node> queue = new LinkedList<>();
queue.add(root);

while (!queue.isEmpty()) {
    depth++;
    final int size = queue.size();
    for (int i = 0; i < size; i++) {
        final Node poll = queue.poll();
        if (Objects.requireNonNull(poll).children != null) {
            queue.addAll(poll.children);
        }
    }
}

        return depth;
    }
}

public class MaxDepthOfNAryTree {
    public static void main(String[] args) {
        Solution solution = new Solution();

        Node node6 = new Node(6, null);
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, null);
        Node node3 = new Node(3, Arrays.asList(node5, node6));
        Node node2 = new Node(2, null);
        Node node1 = new Node(1, Arrays.asList(node3, node2, node4));

        assertThat(solution.maxDepth(node1)).isEqualTo(3);
    }
}
