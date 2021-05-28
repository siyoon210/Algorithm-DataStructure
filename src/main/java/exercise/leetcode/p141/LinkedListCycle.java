package exercise.leetcode.p141;

import static org.assertj.core.api.Assertions.assertThat;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * walker(한칸씩 전진) & runner(두칸씩 전진) 방식으로 탐색한다.
 * 1. runner == null 이라면 cycle x
 * 2. walker == runner 라면 cycle o
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;

        while (runner != null) {
            runner = runner.next;
            if (runner != null) {
                runner = runner.next;
                walker = walker.next;

                if (runner == walker) {
                    return true;
                }
            }
        }

        return false;
    }
}

public class LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode nodeM4 = new ListNode(-4);
        node3.next = node2;
        node2.next = node0;
        node0.next = nodeM4;
        nodeM4.next = node2;
        assertThat(solution.hasCycle(node3)).isEqualTo(true);

        ListNode node1 = new ListNode(1);
        assertThat(solution.hasCycle(node1)).isEqualTo(false);
    }
}
