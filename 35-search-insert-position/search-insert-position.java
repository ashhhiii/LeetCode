class Solution {
    public int searchInsert(int[] nums, int target) {
          int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid; // Search in the left half
            }
        }

        return left; // Return the insertion point
    }
}