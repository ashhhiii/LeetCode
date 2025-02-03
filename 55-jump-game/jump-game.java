class Solution {
    public boolean canJump(int[] nums) {
   int maxReach = 0; // Tracks the farthest index we can reach
        
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // If we reach an index that is not accessible, return false
            }
            maxReach = Math.max(maxReach, i + nums[i]); // Update max reachable index
            if (maxReach >= nums.length - 1) {
                return true; // If we can reach the last index, return true
            }
        }
        
        return false;
   
    }
}