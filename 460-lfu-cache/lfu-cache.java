class LFUCache {

    private final int capacity; // Maximum capacity of the cache
    private int minFrequency; // Tracks the minimum frequency in the cache
    private final Map<Integer, Node> cache; // Key -> Node mapping
    private final Map<Integer, LinkedHashSet<Node>> frequencyMap; // Frequency -> Nodes with that frequency

    // Node to store key, value, and frequency
    private static class Node {
        int key, value, frequency;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1; // Initial frequency is 1
        }
    }

    // Constructor to initialize the LFU cache
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    // Get the value of the key if it exists, otherwise return -1
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        updateFrequency(node);
        return node.value;
    }

    // Put a key-value pair into the cache
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value; // Update the value
            updateFrequency(node);
        } else {
            if (cache.size() == capacity) {
                // Evict the least frequently used (LFU) node
                LinkedHashSet<Node> minFreqNodes = frequencyMap.get(minFrequency);
                Node lfuNode = minFreqNodes.iterator().next();
                minFreqNodes.remove(lfuNode);
                if (minFreqNodes.isEmpty()) {
                    frequencyMap.remove(minFrequency);
                }
                cache.remove(lfuNode.key);
            }

            // Add the new node
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            frequencyMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(newNode);
            minFrequency = 1; // Reset minFrequency to 1 for the new node
        }
    }

    // Update the frequency of a node
    private void updateFrequency(Node node) {
        int oldFreq = node.frequency;
        LinkedHashSet<Node> oldFreqNodes = frequencyMap.get(oldFreq);
        oldFreqNodes.remove(node);
        if (oldFreqNodes.isEmpty()) {
            frequencyMap.remove(oldFreq);
            if (minFrequency == oldFreq) {
                minFrequency++;
            }
        }

        node.frequency++;
        frequencyMap.computeIfAbsent(node.frequency, k -> new LinkedHashSet<>()).add(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */