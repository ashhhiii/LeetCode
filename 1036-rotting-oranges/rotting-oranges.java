class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) return 0;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottenThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newY >= 0 && newX < rows && newY < cols &&
                        grid[newX][newY] == 1) {
                        
                        grid[newX][newY] = 2; 
                        queue.offer(new int[]{newX, newY});
                        freshOranges--;
                        rottenThisMinute = true;
                    }
                }
            }

            if (rottenThisMinute) minutes++;
        }

        return freshOranges == 0 ? minutes : -1;
    }
}