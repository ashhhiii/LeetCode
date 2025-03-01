class Solution {
    public int swimInWater(int[][] grid) {
    int n = grid.length;
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Start from (0,0) with elevation grid[0][0]
        pq.offer(new int[]{grid[0][0], 0, 0});
        int maxElevation = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int elevation = current[0], r = current[1], c = current[2];

            // Update max elevation encountered
            maxElevation = Math.max(maxElevation, elevation);

            // If reached destination (n-1, n-1), return answer
            if (r == n - 1 && c == n - 1) return maxElevation;

            // Mark current cell as visited
            visited[r][c] = true;

            // Explore 4 possible directions
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    pq.offer(new int[]{grid[nr][nc], nr, nc});
                    visited[nr][nc] = true; // Mark as visited early to avoid duplicates
                }
            }
        }
        return -1; // Should never reach here
    }
}