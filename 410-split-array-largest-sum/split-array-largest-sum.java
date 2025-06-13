class Solution {
    public int splitArray(int[] nums, int k) {
          int left = 0, right = 0;
        
        // Determine the range for binary search
        for (int num : nums) {
            left = Math.max(left, num); // max element in the array
            right += num;              // sum of all elements
        }
        
        // Perform binary search
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, k, mid)) {
                right = mid; // try for a smaller largest sum
            } else {
                left = mid + 1; // increase the largest sum limit
            }
        }
        
        return left; // the minimized largest sum
    }
    
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int currentSum = 0, subarrays = 1;
        
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                // Start a new subarray
                subarrays++;
                currentSum = num;
                if (subarrays > k) {
                    return false; // More subarrays than allowed
                }
            } else {
                currentSum += num;
            }
        }
        
        return true;
    
    }
}