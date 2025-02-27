class Solution {
    class DisjointSet {
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> rank = new HashMap<>();

        int find(int x) {
            if (parent.get(x) != x) {
                parent.put(x, find(parent.get(x))); // Path Compression
            }
            return parent.get(x);
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank.get(rootX) > rank.get(rootY)) {
                    parent.put(rootY, rootX);
                } else if (rank.get(rootX) < rank.get(rootY)) {
                    parent.put(rootX, rootY);
                } else {
                    parent.put(rootY, rootX);
                    rank.put(rootX, rank.get(rootX) + 1);
                }
            }
        }

        void add(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                rank.put(x, 0);
            }
        }
    }
    public int removeStones(int[][] stones) {
     DisjointSet ds = new DisjointSet();
        
        for (int[] stone : stones) {
            int row = -(stone[0] + 1); // Negative to separate rows from columns
            int col = stone[1];

            ds.add(row);
            ds.add(col);
            ds.union(row, col);
        }

        Set<Integer> uniqueComponents = new HashSet<>();
        for (int[] stone : stones) {
            uniqueComponents.add(ds.find(-(stone[0] + 1))); // Get unique root parent
        }

        return stones.length - uniqueComponents.size();
    }
}