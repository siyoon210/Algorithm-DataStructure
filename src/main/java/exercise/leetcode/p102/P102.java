package exercise.leetcode.p102;

import exercise.leetcode.treenode.TreeNode;
import exercise.leetcode.treenode.TreeNodeBuilder;

import java.util.*;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();

        if (Objects.nonNull(root)) {
            nodes.add(root);
        }

        while (!nodes.isEmpty()) {
            putSameLevelValue(answer, nodes);
        }

        return answer;
    }

    private void putSameLevelValue(List<List<Integer>> answer, Queue<TreeNode> nodes) {
        int size = nodes.size();
        List<Integer> sameLevelNodeValue = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            final TreeNode poll = nodes.poll();

            if (Objects.isNull(poll)) {
                throw new IllegalStateException();
            }

            if (Objects.nonNull(poll.left)) {
                nodes.add(poll.left);
            }

            if (Objects.nonNull(poll.right)) {
                nodes.add(poll.right);
            }

            sameLevelNodeValue.add(poll.val);
        }

        answer.add(sameLevelNodeValue);
    }
}

public class P102 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        final TreeNode root = TreeNodeBuilder.getBinaryTreeNodeRoot(new Integer[]{3, 9, 20, null, null, 15, 7});
        assertThat(solution.levelOrder(root).size()).isEqualTo(3);

        out.println("p102" + " success!");
    }
}
