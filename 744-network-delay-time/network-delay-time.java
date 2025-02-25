class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
         List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]}); // (destination, time)
        }

        // Step 2: Initialize Dijkstra's Algorithm
        int[] dist = new int[n + 1]; // Store shortest time to reach each node
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; // Start node has 0 delay

        // Step 3: Min-Heap (PriorityQueue) to store (time, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, k}); // (time, node)

        // Step 4: Process the priority queue
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0], node = current[1];

            // Skip processing if we already found a shorter path
            if (time > dist[node]) continue;

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0], travelTime = neighbor[1];
                int newTime = time + travelTime;

                // Relaxation: Update only if we found a shorter path
                if (newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;
                    pq.offer(new int[]{newTime, nextNode});
                }
            }
        }

        // Step 5: Get the maximum time taken to reach all nodes
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // If any node is unreachable
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    
    }
}