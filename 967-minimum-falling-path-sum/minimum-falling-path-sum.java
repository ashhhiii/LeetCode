class Solution {
    public int minFallingPathSum(int[][] matrix) {
     int n = matrix.length;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int left = (j > 0) ? matrix[i - 1][j - 1] : Integer.MAX_VALUE;
                int up = matrix[i - 1][j];
                int right = (j < n - 1) ? matrix[i - 1][j + 1] : Integer.MAX_VALUE;
                
                matrix[i][j] += Math.min(left, Math.min(up, right));
            }
        }
        
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, matrix[n - 1][j]);
        }
        
        return minSum;
    }
}