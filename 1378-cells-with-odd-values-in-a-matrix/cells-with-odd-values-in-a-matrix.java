class Solution {
    public int oddCells(int m, int n, int[][] indices) {
       int[] row = new int[m];
        int[] col = new int[n];

        // Count how many times each row and column is incremented
        for (int[] index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }

        int count = 0;
        // Check each cell to see if its value is odd
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((row[i] + col[j]) % 2 != 0) {
                    count++;
                }
            }
        }

        return count;
    }
}