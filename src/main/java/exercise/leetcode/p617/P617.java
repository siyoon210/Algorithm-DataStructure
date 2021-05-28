package exercise.leetcode.p617;

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
public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
        return t2;
    }

    if (t2 == null) {
        return t1;
    }

    t1.val = t1.val + t2.val;
    t1.left = mergeTrees(t1.left, t2.left);
    t1.right = mergeTrees(t1.right, t2.right);

    return t1;
}
}

public class P617 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode t1_1 = new TreeNode(1);
        TreeNode t1_3 = new TreeNode(3);
        TreeNode t1_2 = new TreeNode(2);
        TreeNode t1_5 = new TreeNode(5);

        t1_1.left = t1_3;
        t1_1.right = t1_2;
        t1_3.left = t1_5;

        TreeNode t2_2 = new TreeNode(2);
        TreeNode t2_1 = new TreeNode(1);
        TreeNode t2_3 = new TreeNode(3);
        TreeNode t2_4 = new TreeNode(4);
        TreeNode t2_7 = new TreeNode(7);

        t2_2.left = t2_1;
        t2_2.right = t2_3;
        t2_1.right = t2_4;
        t2_3.right = t2_7;

        TreeNode treeNode = solution.mergeTrees(t1_1, t2_2);

        assertThat(treeNode.val).isEqualTo(3);
        assertThat(treeNode.left.val).isEqualTo(4);
        assertThat(treeNode.right.val).isEqualTo(5);
        assertThat(treeNode.left.left.val).isEqualTo(5);
        assertThat(treeNode.left.right.val).isEqualTo(4);
        assertThat(treeNode.right.left).isEqualTo(null);
        assertThat(treeNode.right.right.val).isEqualTo(7);
    }
}
