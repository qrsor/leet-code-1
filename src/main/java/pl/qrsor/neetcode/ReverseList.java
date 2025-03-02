package pl.qrsor.neetcode;


public class ReverseList {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        var curr = head;

        while (curr!=null) {
            var nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }
}
