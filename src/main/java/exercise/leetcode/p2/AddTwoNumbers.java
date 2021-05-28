package exercise.leetcode.p2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final BigDecimal bigDecimalL1 = new BigDecimal(getNumStr(l1));
        final BigDecimal bigDecimalL2 = new BigDecimal(getNumStr(l2));
        final BigDecimal sum = bigDecimalL1.add(bigDecimalL2);

        final String sumStr = String.valueOf(sum);
        List<ListNode> listNodes = new ArrayList<>();

        for (int i = 0; i < sumStr.length(); i++) {
            listNodes.add(new ListNode(sumStr.charAt(i) - '0'));
        }

        for (int i = listNodes.size() - 1; i > 0; i--) {
            listNodes.get(i).next = listNodes.get(i - 1);
        }

        return listNodes.get(listNodes.size() - 1);
    }

    String getNumStr(ListNode listNode) {
        if (listNode.next != null) {
            String postNumStr = getNumStr(listNode.next);
            return postNumStr + listNode.val;
        }

        return String.valueOf(listNode.val);
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(3);

        l1_2.next = l1_3;
        l1.next = l1_2;

        ListNode l2 = new ListNode(5);
        ListNode l2_2 = new ListNode(6);
        ListNode l2_3 = new ListNode(4);

        l2_2.next = l2_3;
        l2.next = l2_2;

        Solution solution = new Solution();
        System.out.println(solution.addTwoNumbers(l1, l2)); // 342 + 465 = 807 -> 7 0 8
    }
}
