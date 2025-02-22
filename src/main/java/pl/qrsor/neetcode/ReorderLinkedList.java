package pl.qrsor.neetcode;

public class ReorderLinkedList {
    public void reorderList(ListNode head) {
        if (head == null) return;

        // split list
        var slow = head;
        var fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        var curr = slow.next;
        slow.next = null;
        ListNode prev = null;
        //detach half
        while (curr != null) {
            var tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        // join lists
        var dummy = new ListNode();
        while (head != null && prev != null) {
            dummy.next = head;
            head = head.next;

            dummy = dummy.next;
            dummy.next = prev;

            prev = prev.next;
            dummy = dummy.next;
        }

        if (head != null) {
            dummy.next = head;
        }
    }
}
