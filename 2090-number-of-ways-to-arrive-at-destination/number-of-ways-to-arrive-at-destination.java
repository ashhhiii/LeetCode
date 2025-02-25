

class Solution {
    private static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        // Step 1: Build the adjacency list graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for (int[] road : roads) {
            graph.get(road[0]).add(new int[]{road[1], road[2]});
            graph.get(road[1]).add(new int[]{road[0], road[2]}); // Bidirectional
        }

        // Step 2: Initialize Dijkstra's Algorithm
        long[] dist = new long[n]; // Store shortest time to reach each node
        int[] ways = new int[n];   // Store number of ways to reach each node
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        // Step 3: Min-Heap (PriorityQueue) to store (time, node)
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0}); // (time, node)

        // Step 4: Process the priority queue
        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long time = current[0];
            int node = (int) current[1];

            // If we already found a shorter path, skip processing
            if (time > dist[node]) continue;

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                long travelTime = neighbor[1];
                long newTime = time + travelTime;

                // If we found a shorter path
                if (newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;
                    ways[nextNode] = ways[node]; // Inherit paths count
                    pq.offer(new long[]{newTime, nextNode});
                }
                // If another path with the same shortest time is found
                else if (newTime == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1]; // Return ways to reach destination `n-1`
    }
}
