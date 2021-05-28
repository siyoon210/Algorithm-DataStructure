package exercise.leetcode.p589;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

/**
 * preorder (전위순회) : self, children(left -> right)
 * inorder (중위순회) : left -> self -> right (이진 트리인 경우만 가능)
 * postorder (후위순회): children(left -> right), self
 */

/**
 * 시간복잡도 O(n)
 */
class Solution {
    private List<Integer> answer = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root != null) {
            preorderTraversal(root);
        }
        return answer;
    }

    private void preorderTraversal(final Node node) {
        answer.add(node.val);

        if (node.children == null) {
            return;
        }

        for (final Node child : node.children) {
            preorderTraversal(child);
        }
    }
}

public class NaryTreePreorderTraversal {
    public static void main(String[] args) {
        Node node6 = new Node(6, null);
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, null);
        Node node3 = new Node(3, Arrays.asList(node5, node6));
        Node node2 = new Node(2, null);
        Node node1 = new Node(1, Arrays.asList(node3, node2, node4));

        Solution solution = new Solution();
        assertThat(solution.preorder(node1)).isEqualTo(Arrays.asList(1, 3, 5, 6, 2, 4));
    }
}
