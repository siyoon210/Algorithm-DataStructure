package exercise.leetcode.p234;


import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

public class P234 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.isPalindrome(new ListNode(1, new ListNode(2)))).isEqualTo(false);
        assertThat(solution.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))))).isEqualTo(true);

        out.println("p234" + " success!");
    }
}
