class Solution {
    public int findTargetSumWays(int[] nums, int target) {
     int sum = Arrays.stream(nums).sum();
        if ((sum - target) % 2 != 0 || sum < target) {
            return 0;
        }
        int s2 = (sum - target) / 2;
        
        int[] dp = new int[s2 + 1];
        dp[0] = 1;
        
        for (int num : nums) {
            for (int j = s2; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[s2];
    }
}