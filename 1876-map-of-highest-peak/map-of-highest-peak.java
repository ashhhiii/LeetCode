class Solution {
    public int[][] highestPeak(int[][] isWater) {
         int m = isWater.length, n = isWater[0].length;
        int[][] height = new int[m][n];
        for (int[] row : height) {
            Arrays.fill(row, -1); // Initialize height matrix with -1 (unvisited)
        }

        Queue<int[]> queue = new LinkedList<>();

        // Add all water cells to the queue and set their height to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    height[i][j] = 0; // Water cells have height 0
                }
            }
        }

        // Directions for moving to adjacent cells (N, S, E, W)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // BFS to calculate heights
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // Check if the neighbor is within bounds and unvisited
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && height[nx][ny] == -1) {
                    height[nx][ny] = height[x][y] + 1; // Set height for the neighbor
                    queue.offer(new int[]{nx, ny}); // Add the neighbor to the queue
                }
            }
        }

        return height;
    }

    
}