class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
         int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        
        int reachable = 0;                         // # of true dp[k] in the current window
        
        for (int i = 1; i < n; i++) {
            // window left edge enters at i - minJump
            int enter = i - minJump;
            if (enter >= 0 && dp[enter]) {
                reachable++;
            }
            // window right edge exits at i - maxJump - 1
            int exit = i - maxJump - 1;
            if (exit >= 0 && dp[exit]) {
                reachable--;
            }
            dp[i] = s.charAt(i) == '0' && reachable > 0;
            if (i == n - 1 && dp[i]) return true;  // early exit
        }
        return false;
    
    }
}