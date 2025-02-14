package pl.qrsor.neetcode;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
        this.random = null;
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }

    public List<Integer> toArray() {
        var result = new ArrayList<Integer>();

        var node = this;
        while(node!=null) {
            result.add(node.val);
            result.add(node.random == null ? null : node.random.val);

            node = node.next;
        }

        return result;
    }
}