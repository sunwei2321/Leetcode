import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Problem146_lru_cache {

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public Problem146_lru_cache() {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public Problem146_lru_cache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            return get0(key).val;
        }
    }

    private Node get0(int key) {
        Node node = map.get(key);
        if (node != head) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }

            if (node.next != null) {
                node.next.prev = node.prev;
            }

            if (node == tail) {
                tail = node.prev;
            }
            node.next = head;
            head.prev = node;
            head = node;
            node.prev = null;
        }

        return node;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            get0(key).val = value;
        } else {
            Node node = new Node();
            node.val = value;
            node.key = key;
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
                if (map.size() == capacity) {
                    tail.prev.next = null;
                    map.remove(tail.key);
                    tail = tail.prev;
                }
            }
            map.put(key, node);
        }
    }

    private class Node {
        Node prev;
        Node next;
        int val;
        int key;
    }

    @Test
    public void test() {
        Problem146_lru_cache cache = new Problem146_lru_cache( 2 /* capacity */ );

        cache.get(2);
        cache.put(2, 1);
        cache.put(3, 2);       // returns 1
        cache.get(3);   // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 3);    // evicts key 1
        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
