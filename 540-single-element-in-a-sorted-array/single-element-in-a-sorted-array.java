class Solution {
    public int singleNonDuplicate(int[] nums) {
       int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Ensure mid is even
            if (mid % 2 == 1) {
                mid--;
            }
            
            // Compare the pair
            if (nums[mid] == nums[mid + 1]) {
                // Single element is on the right
                left = mid + 2;
            } else {
                // Single element is on the left
                right = mid;
            }
        }
        
        // Left points to the single element
        return nums[left];
    }
}