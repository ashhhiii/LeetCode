class Solution {
    public int longestOnes(int[] nums, int k) {
     int left = 0; // Left pointer of the sliding window
        int maxLength = 0; // Maximum length of the subarray
        int zeroCount = 0; // Count of 0s in the current window

        for (int right = 0; right < nums.length; right++) {
            // If the current number is 0, increase zeroCount
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Shrink the window from the left if zeroCount exceeds k
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update the maximum length of the window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

}