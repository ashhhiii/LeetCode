class Solution {
    public int findDuplicate(int[] nums) {
       int left = 1;
        int right = nums.length - 1;  // range [1, n]

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Count how many numbers are <= mid
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }

            if (count > mid) {
                // Duplicate is in [left, mid]
                right = mid;
            } else {
                // Duplicate is in [mid+1, right]
                left = mid + 1;
            }
        }

        return left;
    }
    
}