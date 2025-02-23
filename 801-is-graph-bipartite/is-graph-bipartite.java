class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0 = unvisited, 1 = set A, -1 = set B

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) { // If not colored, start DFS
                if (!dfs(graph, i, 1, color)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int node, int c, int[] color) {
        color[node] = c; // Color the node

        for (int neighbor : graph[node]) {
            if (color[neighbor] == c) return false; // Conflict, not bipartite
            if (color[neighbor] == 0 && !dfs(graph, neighbor, -c, color)) return false; // Recur for unvisited nodes
        }
        return true;
    
    }
}