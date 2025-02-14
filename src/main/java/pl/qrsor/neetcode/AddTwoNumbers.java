package pl.qrsor.neetcode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var dummy = new ListNode(0);

        var carry = false;
        var curr = dummy;
        while (l1 != null || l2 != null || carry) {

            var n1 = l1 == null ? 0 : l1.val;
            var n2 = l2 == null ? 0 : l2.val;

            var sum = n1 + n2;
            if (carry) {
                sum++;
                carry = false;
            }

            if (sum >= 10) {
                carry = true;
            }
            curr.next = new ListNode(sum % 10);


            // increment step;
            curr = curr.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }

        return dummy.next;
    }
}
