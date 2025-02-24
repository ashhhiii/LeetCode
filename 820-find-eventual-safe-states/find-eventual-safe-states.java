class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int[] inDegree = new int[n];

        // Step 1: Build the reversed graph
        for (int i = 0; i < n; i++) reverseGraph.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                reverseGraph.get(neighbor).add(i); // Reverse edge
                inDegree[i]++; // Track in-degree
            }
        }

        // Step 2: Add terminal nodes to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        // Step 3: Process nodes in topological order
        List<Integer> safeNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);
            for (int neighbor : reverseGraph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 4: Sort and return the safe nodes
        Collections.sort(safeNodes);
        return safeNodes;
    }
}