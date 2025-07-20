class Solution {
    class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        String name;
        boolean isDeleted = false;
    }

    TrieNode root = new TrieNode();
    Map<String, List<TrieNode>> serializationMap = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        // Step 1: Build the Trie
        for (List<String> path : paths) {
            TrieNode curr = root;
            for (String folder : path) {
                curr.children.putIfAbsent(folder, new TrieNode());
                curr = curr.children.get(folder);
                curr.name = folder;
            }
        }

        // Step 2: Serialize each subtree and store in map
        serialize(root);

        // Step 3: Mark duplicates for deletion
        for (List<TrieNode> nodeList : serializationMap.values()) {
            if (nodeList.size() > 1) {
                for (TrieNode node : nodeList) {
                    node.isDeleted = true;
                }
            }
        }

        // Step 4: Collect non-deleted paths
        List<List<String>> result = new ArrayList<>();
        collectPaths(root, new ArrayList<>(), result);
        return result;
    }

    // Postorder traversal to serialize subtrees
    private String serialize(TrieNode node) {
        if (node.children.isEmpty()) return "";

        List<String> serials = new ArrayList<>();
        for (String key : node.children.keySet()) {
            TrieNode child = node.children.get(key);
            serials.add(key + "(" + serialize(child) + ")");
        }

        // Sort to make serialization order-insensitive
        Collections.sort(serials);
        String serial = String.join("", serials);
        serializationMap.computeIfAbsent(serial, k -> new ArrayList<>()).add(node);
        return serial;
    }

    // DFS to collect paths of remaining folders
    private void collectPaths(TrieNode node, List<String> path, List<List<String>> result) {
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            TrieNode child = entry.getValue();
            if (child.isDeleted) continue;

            path.add(child.name);
            result.add(new ArrayList<>(path));
            collectPaths(child, path, result);
            path.remove(path.size() - 1);
        }
    }
}
