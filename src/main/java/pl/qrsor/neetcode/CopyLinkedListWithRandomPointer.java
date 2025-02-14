package pl.qrsor.neetcode;

import java.util.HashMap;

public class CopyLinkedListWithRandomPointer {
    public Node copyRandomList(Node head) {

        var oldToNewMap = new HashMap<Node, Node>();

        var node = head;
        var dummy = new Node(0);
        var curr = dummy;
        while (node != null) {
            Node newNode = new Node(node.val);
            oldToNewMap.put(node, newNode);
            curr.next = newNode;

            curr = curr.next;
            node = node.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                var newCurr = oldToNewMap.get(curr);
                newCurr.random = oldToNewMap.get(curr.random);
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
