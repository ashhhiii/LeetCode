class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]}); // (destination, price)
        }

        // Step 2: Min-Heap (PriorityQueue) to store (cost, city, stopsLeft)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src, k + 1}); // (cost, city, stopsLeft)

        // Step 3: HashMap to track the minimum cost for a given (city, stopsLeft)
        Map<Integer, Integer>[] costMap = new HashMap[n];
        for (int i = 0; i < n; i++) costMap[i] = new HashMap<>();
        
        // Step 4: Process the queue (Dijkstra-like BFS)
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0], city = current[1], stopsLeft = current[2];

            // If we reached the destination, return the cost
            if (city == dst) return cost;

            // If we have stops left, explore neighbors
            if (stopsLeft > 0) {
                for (int[] neighbor : graph.get(city)) {
                    int nextCity = neighbor[0], price = neighbor[1];
                    int newCost = cost + price;

                    // If this path is better, update and push to queue
                    if (!costMap[nextCity].containsKey(stopsLeft - 1) || newCost < costMap[nextCity].get(stopsLeft - 1)) {
                        costMap[nextCity].put(stopsLeft - 1, newCost);
                        pq.offer(new int[]{newCost, nextCity, stopsLeft - 1});
                    }
                }
            }
        }

        return -1; // If no path found
    }
}