class Solution {
    public int[][] updateMatrix(int[][] mat) {
         int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize distance matrix and push all 0s into the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0; // Distance for 0 remains 0
                    queue.add(new int[]{i, j}); // Enqueue all 0s
                } else {
                    dist[i][j] = Integer.MAX_VALUE; // Initialize 1s as max value
                }
            }
        }

        // Directions for moving Up, Down, Left, Right
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // BFS Traversal
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int[] dir : directions) {
                int newRow = r + dir[0], newCol = c + dir[1];

                // If within bounds and a better distance is found
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    if (dist[newRow][newCol] > dist[r][c] + 1) {
                        dist[newRow][newCol] = dist[r][c] + 1;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return dist;
    }
}