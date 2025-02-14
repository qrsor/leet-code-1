package pl.qrsor.neetcode;

public class RemoveNodeFromEndOfLinkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var dummy = new ListNode(0, head);
        var left = dummy;
        var right = head;

        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        while(right!=null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }
}
