package exercise.leetcode.p530;

import static org.assertj.core.api.Assertions.assertThat;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

/**
 * BST (이진검색트리)는 모든 노드의 왼쪽에는 해당 노드보다 작은값이, 오른쪽에는 해당 노드보다 큰값이 들어간다.
 * 이런 특징을 이용해서 트리를 inorder (중위순회) 하면 작은값부터 큰값까지 순차적으로 순회할 수 있다!
 */
class Solution {
    int min;
    Integer prevValue;

    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        inorderTraversal(root);
        return min;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);

        if (prevValue != null) {
            min = Math.min(min, node.val - prevValue);
        }

        prevValue = node.val;

        inorderTraversal(node.right);
    }
}

public class MinAbsoluteDifferenceInBST {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);

        node1.right = node3;
        node3.left = node2;

        assertThat(solution.getMinimumDifference(node1)).isEqualTo(1);
    }

}
