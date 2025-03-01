class Solution {
     private static final int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int largestIsland(int[][] grid) {
     int n = grid.length;
        Map<Integer, Integer> islandSize = new HashMap<>();
        int islandId = 2; // Start IDs from 2 to distinguish from 0 and 1
        int maxIsland = 0;

        // Step 1: Identify all islands and mark them uniquely
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int size = dfs(grid, r, c, islandId);
                    islandSize.put(islandId, size);
                    maxIsland = Math.max(maxIsland, size);
                    islandId++;
                }
            }
        }

        // Step 2: Check each 0 cell to see the max island size after flipping
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> seenIslands = new HashSet<>();
                    int possibleSize = 1; // Count the flipped cell itself

                    for (int[] dir : directions) {
                        int nr = r + dir[0], nc = c + dir[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] > 1) {
                            int id = grid[nr][nc];
                            if (!seenIslands.contains(id)) {
                                possibleSize += islandSize.get(id);
                                seenIslands.add(id);
                            }
                        }
                    }
                    maxIsland = Math.max(maxIsland, possibleSize);
                }
            }
        }

        // Step 3: If the entire grid is already 1s, return n * n
        return maxIsland == 0 ? n * n : maxIsland;
    }

    // DFS to mark islands with unique IDs and compute size
    private int dfs(int[][] grid, int r, int c, int islandId) {
        int n = grid.length;
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != 1) return 0;

        grid[r][c] = islandId; // Mark cell with island ID
        int size = 1;

        for (int[] dir : directions) {
            size += dfs(grid, r + dir[0], c + dir[1], islandId);
        }
        return size;
    }
}