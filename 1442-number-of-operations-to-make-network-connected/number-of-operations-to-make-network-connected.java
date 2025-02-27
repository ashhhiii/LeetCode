class Solution {
     class DisjointSet {
    int[] parent, rank;
        
        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i; // Each node is its own parent initially
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path Compression
            }
            return parent[x];
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false; // Already in the same component

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
        if (connections.length < n - 1) return -1; // Not enough cables

        DisjointSet ds = new DisjointSet(n);
        int components = n; // Initially, each node is its own component
        int extraCables = 0; // Count redundant edges

        for (int[] conn : connections) {
            if (!ds.union(conn[0], conn[1])) {
                extraCables++; // This edge forms a cycle
            } else {
                components--; // Reduce number of components
            }
        }

        // We need (components - 1) cables to connect all components
        return (extraCables >= components - 1) ? (components - 1) : -1;
    }
}