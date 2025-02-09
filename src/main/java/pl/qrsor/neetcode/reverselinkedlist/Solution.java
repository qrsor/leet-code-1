package pl.qrsor.neetcode.reverselinkedlist;


public class Solution {
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

    public static class ListNode {
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

}
