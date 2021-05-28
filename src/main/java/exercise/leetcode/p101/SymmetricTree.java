package exercise.leetcode.p101;

import exercise.leetcode.treenode.TreeNode;
import exercise.leetcode.treenode.TreeNodeBuilder;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return compare(left.left, right.right) && compare(left.right, right.left);
    }
}

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNodeBuilder.getBinaryTreeNodeRoot(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        assertThat(solution.isSymmetric(root)).isEqualTo(true);
    }
}
