class Solution {
    public int minimumEffortPath(int[][] heights) {
         int n = heights.length, m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); 
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int effort = current[0], r = current[1], c = current[2];

            if (r == n - 1 && c == m - 1) return effort;

            for (int[] d : directions) {
                int newR = r + d[0], newC = c + d[1];

                if (newR >= 0 && newR < n && newC >= 0 && newC < m) {
                    int newEffort = Math.max(effort, Math.abs(heights[newR][newC] - heights[r][c]));

                    if (newEffort < dist[newR][newC]) {
                        dist[newR][newC] = newEffort;
                        pq.offer(new int[]{newEffort, newR, newC});
                    }
                }
            }
        }

        return -1; 
    }
}