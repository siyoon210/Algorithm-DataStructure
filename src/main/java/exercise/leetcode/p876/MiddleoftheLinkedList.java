package exercise.leetcode.p876;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(final int val, final ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * 시간복잡도 O(n), 공간복잡도 O(n)
 */

//class Solution {
//    private int size = 1;
//    private List<ListNode> listNodes = new ArrayList<>();
//
//    public ListNode middleNode(ListNode head) {
//        checkSizeAndAddNodes(head);
//        return listNodes.get(size / 2);
//    }
//
//    private void checkSizeAndAddNodes(final ListNode node) {
//        listNodes.add(node);
//        if (node.next != null) {
//            size++;
//            checkSizeAndAddNodes(node.next);
//        }
//    }
//}

/**
 * 시간복잡도 O(n), 공간복잡도 O(1)
 * Walker & Runner 테크닉 - 중간지점을 찾기 위한 방법
 * 1. Walker는 한칸씩 전진한다.
 * 2. Runner는 두칸씩 전진한다.
 * 3. Runner가 더 이상 전진하지 못할때의 Walker의 위치는 중간지점이다.
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;

        while (runner != null && runner.next != null) {
            walker = walker.next; //한칸씩 전진
            runner = runner.next.next; //두칸씩 전진
        }

        return walker;
    }
}
public class MiddleoftheLinkedList {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode n6 = new ListNode(6, null);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        assertThat(solution.middleNode(n1)).isEqualTo(n4);
    }
}
