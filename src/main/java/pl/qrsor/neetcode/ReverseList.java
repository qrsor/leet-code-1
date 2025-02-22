package pl.qrsor.neetcode;


public class ReverseList {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        var curr = head;

        while (curr!=null) {
            var tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }
}
