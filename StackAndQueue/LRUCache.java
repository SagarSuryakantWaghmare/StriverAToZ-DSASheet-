import java.util.*;

public class LRUCache {
    // Design a data structure that follows the constraints of a least recently used (LRU) cache.
    /*
     * Implement the LRU cache class:
     * LRUCache(int capacity) : Initializes the LRU cache with positive size Capacity.
     * int get(int key) : Return the value of the key if the key exists, otherwise return -1.
     * void put(int key, int value) : Update the value of the key if the key exists.
     * Otherwise, add the key-value pair to the cache.
     * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
     * The functions get and put must each run in O(1) average time complexity.
     *
     * LRUCache(4)
     * put(2,6)
     * put(4,7)
     * put(8,11)
     * put(7,10)
     * get(2)
     * get(8)
     * get(5)
     * get(7)
     * put(5,7)
     */

    static class ListNode {
        int key, val;
        ListNode prev, next;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    static class LRUcache {
        private final Map<Integer, ListNode> map;
        private final int capacity;
        private final ListNode head, tail;

        LRUcache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            
            head = new ListNode(-1, -1);
            tail = new ListNode(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            ListNode node = map.get(key);
            remove(node);
            insertAfterHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                ListNode node = map.get(key);
                node.val = value;
                remove(node);
                insertAfterHead(node);
            } else {
                if (map.size() == capacity) {
                    ListNode lru = tail.prev;
                    map.remove(lru.key);
                    remove(lru);
                }
                ListNode newNode = new ListNode(key, value);
                map.put(key, newNode);
                insertAfterHead(newNode);
            }
        }

        private void remove(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void insertAfterHead(ListNode node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
    }

    public static void main(String[] args) {
        LRUcache cache = new LRUcache(4);
        cache.put(2, 6);
        cache.put(4, 7);
        cache.put(8, 11);
        cache.put(7, 10);
        System.out.println(cache.get(2)); // 6
        System.out.println(cache.get(8)); // 11
        System.out.println(cache.get(5)); // -1
        System.out.println(cache.get(7)); // 10
        cache.put(5, 7);
    }
}
