class Solution {
    public int maxProfit(int k, int[] prices) {
      if (prices.length == 0 || k == 0) return 0;
        
        int n = prices.length;
        if (2 * k > n) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
        
        int[][] dp = new int[k + 1][n];
        
        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[t][i] = Math.max(dp[t][i - 1], prices[i] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[t - 1][i] - prices[i]);
            }
        }
        
        return dp[k][n - 1];
    }
}