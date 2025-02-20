package pl.qrsor.neetcode;

public class MergeKSortedLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        var dummy = new ListNode(Integer.MIN_VALUE);
        var current = dummy;
        for (ListNode list : lists) {
            current = merge(current, list);
        }

        return dummy.next;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        var dummy = new ListNode();

        var current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 == null) {
            current.next = l2;
        } else {
            current.next = l1;
        }

        return dummy.next;
    }
}
