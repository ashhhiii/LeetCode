class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
      int INF = 100000000; // Large number to represent infinity
        int[][] dist = new int[n][n];

        // Step 1: Initialize distance matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; // Distance to self is 0
        }
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w; // Bidirectional edge
        }

        // Step 2: Floyd-Warshall Algorithm to compute shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Step 3: Count reachable cities for each node
        int minNeighbors = Integer.MAX_VALUE;
        int resultCity = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            // Step 4: Find the city with the smallest neighbors, or largest index if tie
            if (count <= minNeighbors) {
                minNeighbors = count;
                resultCity = i;
            }
        }

        return resultCity;
    }
}