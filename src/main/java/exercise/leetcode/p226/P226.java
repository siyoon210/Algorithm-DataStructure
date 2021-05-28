package exercise.leetcode.p226;

import static org.assertj.core.api.Assertions.assertThat;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        invertTree(root.left);
        invertTree(root.right);

        swapNode(root);

        return root;
    }

    private void swapNode(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}

public class P226 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode case1 = solution.invertTree(firstCase());
        assertThat(case1.val).isEqualTo(4);
        assertThat(case1.left.val).isEqualTo(7);
        assertThat(case1.right.val).isEqualTo(2);
        assertThat(case1.left.left.val).isEqualTo(9);
        assertThat(case1.left.right.val).isEqualTo(6);
        assertThat(case1.right.left.val).isEqualTo(3);
        assertThat(case1.right.right.val).isEqualTo(1);
    }

    private static TreeNode firstCase() {
        TreeNode t4 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t7 = new TreeNode(7);
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t9 = new TreeNode(9);

        t4.left = t2;
        t4.right = t7;
        t2.left = t1;
        t2.right = t3;
        t7.left = t6;
        t7.right = t9;

        return t4;
    }
}
