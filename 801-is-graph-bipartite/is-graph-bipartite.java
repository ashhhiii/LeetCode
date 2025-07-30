class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; 

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!dfs(i, 1, color, graph)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs( int node , int col , int[] color, int[][] graph){
        color[node] = col;
        for (int neighbour : graph[node]){
            if(color[neighbour] == 0){
                if(!dfs(neighbour , -col , color, graph)){
                    return false;
                }
            }else if(color[neighbour] == col){
                return false;
            }
        }
        return true;
    }
}