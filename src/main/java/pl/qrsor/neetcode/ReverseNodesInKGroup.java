package pl.qrsor.neetcode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        var dummy = new ListNode(-999, head);
        var prevGroup = dummy;

        while (true) {
            var elementK = getElementK(prevGroup, k);
            if (elementK == null) {
                return dummy.next;
            }
            var groupNext = elementK.next;

            var prev = elementK.next;
            var curr = prevGroup.next;
            while (curr != groupNext) {
                var tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            var tmp = prevGroup.next;
            prevGroup.next = elementK;
            prevGroup = tmp;
        }
    }

    private ListNode getElementK(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
