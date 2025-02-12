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
}
