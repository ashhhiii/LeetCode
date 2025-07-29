class Solution {
    public int findCircleNum(int[][] isConnected) {
         int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(int[][] connected, boolean[] visited, int city) {
        visited[city] = true;
        for (int i = 0; i < connected.length; i++) {
            if (connected[city][i] == 1 && !visited[i]) {
                dfs(connected, visited, i);
            }
        }
    }
}