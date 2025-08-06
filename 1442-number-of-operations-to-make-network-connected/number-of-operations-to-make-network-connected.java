class Solution {
     class DisjointSet {
    int[] parent, rank;
        
        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
          int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false;

            // Union by Rank
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1; 

        DisjointSet ds = new DisjointSet(n);
        int components = n; 
        int extraCables = 0; 

        for (int[] conn : connections) {
            if (!ds.union(conn[0], conn[1])) {
                extraCables++;
            } else {
                components--; 
            }
        }
        return (extraCables >= components - 1) ? (components - 1) : -1;
    }
}