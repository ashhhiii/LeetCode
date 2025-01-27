class LRUCache {
 private final int capacity; // Maximum capacity of the cache
    private final Map<Integer, Node> cache; // Map to store key -> Node mapping
    private final DoublyLinkedList dll; // Doubly Linked List to maintain LRU order

    // Node for the doubly linked list
    private static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Doubly Linked List class
    private static class DoublyLinkedList {
        private final Node head, tail; // Dummy head and tail nodes

        DoublyLinkedList() {
            head = new Node(-1, -1); // Dummy head
            tail = new Node(-1, -1); // Dummy tail
            head.next = tail;
            tail.prev = head;
        }

        // Move a node to the head (most recently used)
        void moveToHead(Node node) {
            remove(node);
            addToHead(node);
        }

        // Add a new node to the head of the list
        void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        // Remove a node from the list
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Remove and return the least recently used node (from the tail)
        Node removeTail() {
            Node lru = tail.prev;
            remove(lru);
            return lru;
        }
    }

    // Constructor to initialize the cache
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.dll = new DoublyLinkedList();
    }

    // Get the value of the key if it exists, otherwise return -1
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        dll.moveToHead(node); // Mark as recently used
        return node.value;
    }

    // Put a key-value pair into the cache
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            dll.moveToHead(node); // Mark as recently used
        } else {
            if (cache.size() == capacity) {
                Node lru = dll.removeTail(); // Remove least recently used
                cache.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            dll.addToHead(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */