package exercise.leetcode.p701;

import static org.assertj.core.api.Assertions.assertThat;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        search(root, val);

        return root;
    }

    private void search(TreeNode node, int val) {
        if (node == null) {
            return;
        }

        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
                return;
            }
            search(node.left, val);
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
                return;
            }
            search(node.right, val);
        }
    }
}

public class InsertIntoABST {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        node4.left = node2;
        node4.right = node7;
        node2.left = node1;
        node2.right = node3;

        assertThat(solution.insertIntoBST(node4, 5).right.left.val).isEqualTo(5);
    }
}
