package exercise.leetcode.p965;


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    private int rootValue;
    private boolean isUnivalTree = true;

    public boolean isUnivalTree(TreeNode root) {
        rootValue = root.val;
        checkUnival(root);
        return isUnivalTree;
    }

    private void checkUnival(TreeNode node) {
        if (node.val != rootValue) {
            isUnivalTree = false;
        }

        if (!isUnivalTree) {
            return;
        }

        if (node.left != null) {
            checkUnival(node.left);
        }

        if (node.right != null) {
            checkUnival(node.right);
        }
    }
}
public class UnivaluedBinaryTree {
    public static void main(String[] args) {

    }
}
