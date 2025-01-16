class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       Set<String> wordSet = new HashSet<>(wordDict);

        // Create a DP array where dp[i] indicates if s[0..i-1] can be segmented
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Base case: an empty string can always be segmented

        // Fill the DP array
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // Check if the substring s[j..i-1] is in the dictionary and
                // if s[0..j-1] can be segmented
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further if we found a valid segmentation
                }
            }
        }

        return dp[s.length()];
    }
}