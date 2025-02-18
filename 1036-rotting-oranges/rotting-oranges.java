class Solution {
    public int orangesRotting(int[][] grid) {
      int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        
        // Step 1: Add all rotten oranges to queue & count fresh ones
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        
        // If no fresh oranges, return 0 immediately
        if (freshOranges == 0) return 0;
        
        int minutes = 0;
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}}; // 4 possible directions
        
        // Step 2: BFS traversal to rot adjacent fresh oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newY >= 0 && newX < m && newY < n && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2; // Rot the fresh orange
                        queue.offer(new int[]{newX, newY});
                        freshOranges--;
                        rotted = true;
                    }
                }
            }

            if (rotted) minutes++; // Increase time only if at least one orange got rotten
        }
        
        // Step 3: If any fresh orange is left, return -1
        return freshOranges == 0 ? minutes : -1;
    }
}