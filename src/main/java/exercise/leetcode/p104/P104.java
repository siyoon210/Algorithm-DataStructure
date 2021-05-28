package exercise.leetcode.p104;

import java.util.LinkedList;
import java.util.Queue;

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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = nodeQueue.poll();

                if (poll.left != null) {
                    nodeQueue.offer(poll.left);
                }

                if (poll.right != null) {
                    nodeQueue.offer(poll.right);
                }
            }
            depth++;
        }

        return depth;
    }
}

public class P104 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.maxDepth(firstCase())).isEqualTo(3);
        assertThat(solution.maxDepth(secondCase())).isEqualTo(3);
    }

    private static TreeNode firstCase() {
        TreeNode t3 = new TreeNode(3);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);

        t3.left = t9;
        t3.right = t20;
        t20.left = t15;
        t20.right = t7;
        return t3;
    }

    private static TreeNode secondCase() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        return t1;
    }
}
