package exercise.leetcode.p94;


import exercise.leetcode.treenode.TreeNode;
import exercise.leetcode.treenode.TreeNodeBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * preorder (전위순회) self left right
 * inorder (중위 순회) left self right
 * postorder (후위 순회) left right self
 */
class Solution {
    private final List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorder(root);
        }
        return result;
    }

    private void inorder(TreeNode node) {
        if (node.left != null) {
            inorder(node.left);
        }

        result.add(node.val);

        if (node.right != null) {
            inorder(node.right);
        }
    }
}

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Solution();

        final TreeNode root = TreeNodeBuilder.getBinaryTreeNodeRoot(new Integer[]{
                1,
                null, 2,
                null, null, 3, null
        });

        assertThat(solution.inorderTraversal(root)).isEqualTo(Arrays.asList(1, 3, 2));
    }
}
