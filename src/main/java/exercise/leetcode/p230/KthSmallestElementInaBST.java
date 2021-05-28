package exercise.leetcode.p230;


import static org.assertj.core.api.Assertions.assertThat;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

}

/**
 * BST 이진 탐색 트리를 중위순회하면 트리의 요소들을 작은것부터 차례대로 방문 할 수 있다.
 */
class Solution {
    private int k;
    private int orderSequence;
    private int answer;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        orderSequence = 0;

        inorder(root);

        return answer;
    }

    private boolean inorder(TreeNode node) {
        if (node == null) {
            return false;
        }

        final boolean inorderLeft = inorder(node.left);
        if (inorderLeft) {
            return true;
        }

        orderSequence++;
        if (k == orderSequence) {
            answer = node.val;
            return true;
        }

        final boolean inorderRight = inorder(node.right);
        if (inorderRight) {
            return true;
        }

        return false;
    }
}

public class KthSmallestElementInaBST {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);

        node3.left = node1;
        node3.right = node4;
        node1.right = node2;

        Solution solution = new Solution();
        assertThat(solution.kthSmallest(node3, 1)).isEqualTo(1);
    }
}
