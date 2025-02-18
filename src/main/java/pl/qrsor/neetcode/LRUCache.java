package pl.qrsor.neetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final Map<Integer, Node> cache;
    private final Node left = new Node(-100,0,null,null);
    private Node right = new Node(100,0,null,null);
    private final int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.capacity = capacity;
        left.next = right;
        right.prev = left;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        var node = cache.get(key);

        remove(node);
        insert(node);

        return node.val;
    }

    private void insert(Node node) {
        right.prev.next = node;
        node.prev = right.prev;
        node.next = right;
        right.prev = node;
    }

    private void remove(Node node) {
        var prv = node.prev;
        var nxt = node.next;
        prv.next = nxt;
        nxt.prev = prv;
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            var node = cache.get(key);
            remove(node);
        }

        var node = new Node(key, value, null, null);
        cache.put(key, node);
        insert(node);

        if (cache.size() > this.capacity) {
            evict();
        }
    }

    private void evict() {
        var lru = left.next;

        remove(lru);
        cache.remove(lru.key);
    }

    private static class Node {

        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        int key;
        int val;
        Node prev;
        Node next;
    }
}
