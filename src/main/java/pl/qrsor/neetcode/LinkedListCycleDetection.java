package pl.qrsor.neetcode;

public class LinkedListCycleDetection {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        var slow = head;
        var fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }

        return false;
    }
}
