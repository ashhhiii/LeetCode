class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int pro = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                pro++;
                 dfs(isConnected, visited, i);
            }
        }
        return pro;
    }
    private void dfs(int[][] isConnected, boolean[] visited,int city){
       visited[city] = true;
        for(int i =0;i<isConnected.length;i++){
            if(isConnected[city][i] == 1 && !visited[i]){
                 dfs(isConnected, visited, i);
            }
        }
    }
}