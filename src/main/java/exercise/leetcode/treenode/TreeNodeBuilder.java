package exercise.leetcode.treenode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreeNodeBuilder {
    private TreeNodeBuilder() {}

    public static TreeNode getBinaryTreeNodeRoot(Integer[] nodeArray) {
        final List<TreeNode> treeNodes = new ArrayList<>();

        if (nodeArray.length == 0) {
            return null;
        }

        setRootNode(nodeArray[0], treeNodes);

        for (int i = 1; i < nodeArray.length; i++) {
            if (Objects.isNull(nodeArray[i])) {
                treeNodes.add(null);
                continue;
            }

            final TreeNode treeNode = new TreeNode(nodeArray[i]);
            setParent(treeNodes, treeNode, i);
            treeNodes.add(treeNode);
        }

        return treeNodes.get(0);
    }

    private static void setRootNode(int val, List<TreeNode> treeNodes) {
        final TreeNode root = new TreeNode(val);
        treeNodes.add(root);
    }

    private static void setParent(List<TreeNode> treeNodes, TreeNode childNode, int childIndex) {
        final int parentNodeIndex = getParentNodeIndex(childIndex);
        final TreeNode parentNode = treeNodes.get(parentNodeIndex);

        if (isLeftChild(childIndex)) {
            parentNode.left = childNode;
        } else {
            parentNode.right = childNode;
        }
    }

    private static int getParentNodeIndex(int childIndex) {
        if (isLeftChild(childIndex)) {
            return (childIndex - 1) / 2;
        } else {
            return (childIndex - 2) / 2;
        }
    }

    private static boolean isLeftChild(int index) {
        return isOddNumber(index);
    }

    private static boolean isOddNumber(int i) {
        return i % 2 != 0;
    }
}
