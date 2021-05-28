package exercise.leetcode.p938;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(final int val) {
        this.val = val;
    }
}

class Solution {
    private int sum = 0;
    private int L;
    private int R;

    public int rangeSumBST(TreeNode root, int L, int R) {
        this.L = L;
        this.R = R;

        rangeSumBST(root);
        return sum;
    }

    private void rangeSumBST(TreeNode node) {
        if (node.left != null) {
            rangeSumBST(node.left);
        }

        if (node.right != null) {
            rangeSumBST(node.right);
        }

        if (node.val >= L && node.val <= R) {
            sum += node.val;
        }
    }
}

public class RangeSumOfBST {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(10);
        TreeNode B = new TreeNode(5);
        TreeNode C = new TreeNode(15);
        TreeNode D = new TreeNode(3);
        TreeNode E = new TreeNode(7);
        TreeNode F = new TreeNode(18);

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.right = F;

        Solution solution = new Solution();
        System.out.println(solution.rangeSumBST(A, 7, 15));
    }
}
