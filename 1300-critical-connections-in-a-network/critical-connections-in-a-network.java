class Solution {
    private int time=0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    List<List<Integer>> result = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (List<Integer> conn : connections) {
            graph[conn.get(0)].add(conn.get(1));
            graph[conn.get(1)].add(conn.get(0));
        }
        
        int[] discovery = new int[n];
        int[] low = new int[n];
        Arrays.fill(discovery, -1);
        
        dfs(0, -1, discovery, low, graph, result);
        
        return result;
    }
    
    private void dfs(int node, int parent, int[] discovery, int[] low, List<Integer>[] graph, List<List<Integer>> result) {
        discovery[node] = low[node] = time++;
        
        for (int neighbor : graph[node]) {
            if (neighbor == parent) continue;
            
            if (discovery[neighbor] == -1) {
                dfs(neighbor, node, discovery, low, graph, result);
                low[node] = Math.min(low[node], low[neighbor]);
                
                if (low[neighbor] > discovery[node]) {
                    result.add(Arrays.asList(node, neighbor));
                }
            } else {
                low[node] = Math.min(low[node], discovery[neighbor]);
            }
        }
    }
}