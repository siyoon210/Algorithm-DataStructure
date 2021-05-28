package exercise.leetcode.treenode;

import static org.assertj.core.api.Assertions.assertThat;

class TreeNodeBuilderTest {
    public static void main(String[] args) {
        Integer[] nodeArray = new Integer[]{10, 20, 30, 40, 50};
        final TreeNode root = TreeNodeBuilder.getBinaryTreeNodeRoot(nodeArray);

        assert root != null;
        assertThat(root.val).isEqualTo(10);
        assertThat(root.left.val).isEqualTo(20);
        assertThat(root.right.val).isEqualTo(30);
        assertThat(root.left.left.val).isEqualTo(40);
        assertThat(root.left.right.val).isEqualTo(50);
        assertThat(root.right.left).isEqualTo(null);
        assertThat(root.right.right).isEqualTo(null);

        Integer[] nodeArray2 = new Integer[]{10, 20, null, null, 50};
        final TreeNode root2 = TreeNodeBuilder.getBinaryTreeNodeRoot(nodeArray2);

        assert root2 != null;
        assertThat(root2.val).isEqualTo(10);
        assertThat(root2.left.val).isEqualTo(20);
        assertThat(root2.right).isEqualTo(null);
        assertThat(root2.left.left).isEqualTo(null);
        assertThat(root2.left.right.val).isEqualTo(50);
    }
}
