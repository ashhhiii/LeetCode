class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the rightmost, the minimum is in the right part
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else { 
                // Otherwise, the minimum is in the left part or at mid
                right = mid;
            }
        }

        // At the end of the loop, left == right and points to the minimum element
        return nums[left];
    }
}