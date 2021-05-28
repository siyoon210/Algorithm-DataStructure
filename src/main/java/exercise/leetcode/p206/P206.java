package exercise.leetcode.p206;

import java.util.Stack;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> listNodes = new Stack<>();

        if (head == null) {
            return null;
        }

        ListNode curr = head;

        while (curr.next != null) {
            listNodes.push(curr);
            curr = curr.next;
        }

        ListNode tail = curr;

        while (!listNodes.empty()) {
            ListNode pop = listNodes.pop();
            curr.next = pop;
            curr = pop;
        }

        curr.next = null;

        return tail;
    }
}

public class P206 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node = solution.reverseList(node1);
        assertThat(node.val).isEqualTo(5);
        assertThat(node.next.val).isEqualTo(4);
        assertThat(node.next.next.val).isEqualTo(3);
        assertThat(node.next.next.next.val).isEqualTo(2);
        assertThat(node.next.next.next.next.val).isEqualTo(1);
        assertThat(node.next.next.next.next.next).isEqualTo(null);
    }
}
