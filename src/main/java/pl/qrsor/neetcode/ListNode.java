package pl.qrsor.neetcode;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public List<Integer> toValList() {
        var values = new ArrayList<Integer>();
        var node = this;
        do {
            values.add(node.val);
            node = node.next;
        } while (node != null);
        return values;
    }

    /**
     * 1 -> [0]
     * 21 -> [2,1]
     * 120 -> [0,2,1]
     *
     * @param number number to convert
     */
    public static ListNode fromInteger(int number) {
        var numberAsString = Integer.toString(number);

        var dummy = new ListNode(0);
        var curr = dummy;
        for (int i = numberAsString.length() - 1; i >= 0; i--) {
            curr.next = new ListNode(Character.getNumericValue(numberAsString.charAt(i)));
            curr = curr.next;
        }

        return dummy.next;
    }
}
