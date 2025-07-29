class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // To track the last index where a particular bit was seen
        int[] bitLastSeen = new int[32];

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Update bitLastSeen with current number's bits
            for (int b = 0; b < 32; b++) {
                if ((nums[i] & (1 << b)) != 0) {
                    bitLastSeen[b] = i;
                }
            }

            // The farthest we need to go to include all needed bits
            int maxReach = i;
            for (int b = 0; b < 32; b++) {
                maxReach = Math.max(maxReach, bitLastSeen[b]);
            }

            result[i] = maxReach - i + 1;
        }

        return result;
    
    }
}