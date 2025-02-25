class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
         int n = grid.length;
        
        // Step 1: Base Case - If start or end is blocked, return -1
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        // Step 2: Initialize BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // (row, col, distance)
        grid[0][0] = 1; // Mark as visited

        // Step 3: Define 8-Directional Moves
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, +1}, {0, -1}, {0, +1}, {+1, -1}, {+1, 0}, {+1, +1}
        };

        // Step 4: BFS Processing
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1], dist = current[2];

            // If we reached the destination
            if (r == n - 1 && c == n - 1) return dist;

            for (int[] d : directions) {
                int newR = r + d[0], newC = c + d[1];

                // Check if within bounds and valid
                if (newR >= 0 && newR < n && newC >= 0 && newC < n && grid[newR][newC] == 0) {
                    queue.offer(new int[]{newR, newC, dist + 1});
                    grid[newR][newC] = 1; // Mark as visited
                }
            }
        }

        // Step 5: If no path found, return -1
        return -1;
    }

}