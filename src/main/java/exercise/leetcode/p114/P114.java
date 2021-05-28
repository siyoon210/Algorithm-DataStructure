package exercise.leetcode.p114;

import exercise.leetcode.treenode.TreeNode;
import exercise.leetcode.treenode.TreeNodeBuilder;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 시간복잡도: 순회하는 n, 삽입하는데 n = 2n -> O(n)
 * 공간복잡도: 주어진 입력값 이외에 순서대로 담는 리스트 크기 n -> O(n)
 */
class Solution {
    public void flatten(TreeNode root) {
        final List<TreeNode> sortedList = new ArrayList<>();
        preTraversal(sortedList, root);

        TreeNode lastNode = root;
        for (int i = 1; i < sortedList.size(); i++) {
            lastNode.left = null;
            lastNode.right = sortedList.get(i);
            lastNode = lastNode.right;
        }
    }

    private void preTraversal(List<TreeNode> sortedList, TreeNode node) {
        if (node == null) {
            return;
        }

        sortedList.add(node);
        preTraversal(sortedList, node.left);
        preTraversal(sortedList, node.right);
    }
}

public class P114 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        final TreeNode root = TreeNodeBuilder.getBinaryTreeNodeRoot(new Integer[]{1, 2, 5, 3, 4, null, 6});
        solution.flatten(root);
        assertThat(root).isNotNull();
        assertThat(root.val).isEqualTo(1);
        assertThat(root.left).isNull();
        assertThat(root.right.val).isEqualTo(2);
        assertThat(root.right.left).isNull();
        assertThat(root.right.right.val).isEqualTo(3);
        assertThat(root.right.right.left).isNull();
        assertThat(root.right.right.right.val).isEqualTo(4);
        assertThat(root.right.right.right.left).isNull();
        assertThat(root.right.right.right.right.val).isEqualTo(5);
        assertThat(root.right.right.right.right.left).isNull();
        assertThat(root.right.right.right.right.right.val).isEqualTo(6);
        assertThat(root.right.right.right.right.right.left).isNull();

        out.println("p114" + " success!");
    }
}
