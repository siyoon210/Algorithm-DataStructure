package exercise.leetcode.p173;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class BSTIterator {
    Stack<TreeNode> ancestorNodes = new Stack<>();
    TreeNode currNode;

    public BSTIterator(TreeNode root) {
        currNode = root;
    }

    /** @return the next smallest number */
    public int next() {
        while (currNode.left != null) {
            ancestorNodes.push(currNode);
            currNode = currNode.left;
        }

        int nextVal = currNode.val;

        if (!ancestorNodes.isEmpty()) {
            currNode = ancestorNodes.pop();
            currNode.left = null;
        } else if(currNode.right != null){
            currNode = currNode.right;
        } else {
            currNode = null;
        }

        return nextVal;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (!ancestorNodes.isEmpty()) {
            return true;
        }

        if (currNode != null && currNode.right != null) {
            return true;
        }

        return currNode != null;
    }
}

public class BinarySearchTreeIterator {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3);
        TreeNode node15 = new TreeNode(15);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);

        node7.left = node3;
        node7.right = node15;
        node15.left = node9;
        node15.right = node20;

        BSTIterator iterator = new BSTIterator(node7);
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.next()).isEqualTo(7);
        assertThat(iterator.hasNext()).isEqualTo(true);
        assertThat(iterator.next()).isEqualTo(9);
        assertThat(iterator.hasNext()).isEqualTo(true);
        assertThat(iterator.next()).isEqualTo(15);
        assertThat(iterator.hasNext()).isEqualTo(true);
        assertThat(iterator.next()).isEqualTo(20);
        assertThat(iterator.hasNext()).isEqualTo(false);
    }
}
