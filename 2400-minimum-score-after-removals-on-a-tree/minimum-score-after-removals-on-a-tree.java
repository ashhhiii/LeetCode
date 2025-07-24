class Solution {
     int[] nums;
    List<Integer>[] tree;
    int[] xor;
    int[] inTime, outTime;
    int time = 0;
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        this.nums = nums;
        tree = new List[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        xor = new int[n];
        inTime = new int[n];
        outTime = new int[n];
        dfs(0, -1);

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = i, b = j;
                int x = xor[a], y = xor[b];
                int z = xor[0];

                if (isAncestor(a, b)) {
                    x = xor[b];
                    y = xor[a] ^ xor[b];
                    z = xor[0] ^ xor[a];
                } else if (isAncestor(b, a)) {
                    x = xor[a];
                    y = xor[b] ^ xor[a];
                    z = xor[0] ^ xor[b];
                } else {
                    x = xor[a];
                    y = xor[b];
                    z = xor[0] ^ xor[a] ^ xor[b];
                }

                int max = Math.max(x, Math.max(y, z));
                int min = Math.min(x, Math.min(y, z));
                res = Math.min(res, max - min);
            }
        }
        return res;
    }

    void dfs(int node, int parent) {
        inTime[node] = ++time;
        xor[node] = nums[node];
        for (int nei : tree[node]) {
            if (nei == parent) continue;
            dfs(nei, node);
            xor[node] ^= xor[nei];
        }
        outTime[node] = ++time;
    }

    boolean isAncestor(int u, int v) {
        return inTime[u] <= inTime[v] && outTime[v] <= outTime[u];
    
    }
}