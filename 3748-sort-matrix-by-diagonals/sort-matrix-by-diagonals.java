class Solution {
    public int[][] sortMatrix(int[][] grid) {
       int n = grid.length;
        Map<Integer, List<Integer>> diagonals = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                diagonals.putIfAbsent(key, new ArrayList<>());
                diagonals.get(key).add(grid[i][j]);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : diagonals.entrySet()) {
            List<Integer> diag = entry.getValue();
            if (entry.getKey() >= 0) {
                diag.sort(Collections.reverseOrder());
            } else {
                Collections.sort(diag);
            }
        }

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                int idx = indexMap.getOrDefault(key, 0);
                grid[i][j] = diagonals.get(key).get(idx);
                indexMap.put(key, idx + 1);
            }
        }

        return grid;
    
    }
}