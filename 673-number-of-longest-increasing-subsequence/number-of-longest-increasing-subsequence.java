class Solution {
    public int findNumberOfLIS(int[] nums) {
       int n = nums.length;
        if (n == 0) return 0;
        
        int[] dp = new int[n]; // Length of LIS ending at index i
        int[] count = new int[n]; // Count of LIS ending at index i
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        
        int maxLen = 1;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j]; // Reset count to count[j]
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j]; // Add count[j] to count[i]
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) {
                result += count[i];
            }
        }
        
        return result;
    }
}