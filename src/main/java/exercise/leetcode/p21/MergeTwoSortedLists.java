package exercise.leetcode.p21;

import static org.assertj.core.api.Assertions.assertThat;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
     public ListNode(int val, ListNode next) {
         this.val = val;
         this.next = next;
     }
 }

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result;

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            result = l1;
            l1.next = mergeTwoLists(l1.next, l2);
        } else {
            result = l2;
            l2.next = mergeTwoLists(l1, l2.next);
        }

        return result;
    }
}

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode n1_4 = new ListNode(4, null);
        ListNode n1_2 = new ListNode(2, n1_4);
        ListNode n1_1 = new ListNode(1, n1_2);

        ListNode n2_4 = new ListNode(4, null);
        ListNode n2_3 = new ListNode(3, n2_4);
        ListNode n2_1 = new ListNode(1, n2_3);

        ListNode a6 = new ListNode(4, null);
        ListNode a5 = new ListNode(4, a6);
        ListNode a4 = new ListNode(3, a5);
        ListNode a3 = new ListNode(2, a4);
        ListNode a2 = new ListNode(1, a3);
        ListNode a1 = new ListNode(1, a2);

        final ListNode listNode = solution.mergeTwoLists(n1_1, n2_1);
        printListNode(listNode);
        assertThat(solution.mergeTwoLists(n1_1, n2_1)).isEqualTo(a1);
    }

    private static void printListNode(ListNode listNode) {
        if (listNode == null) {
            return;
        }

        System.out.println(listNode.val);
        printListNode(listNode.next);
    }
}
