class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                // Minimum is in the left half (including mid)
                right = mid;
            } else if (nums[mid] > nums[right]) {
                // Minimum is in the right half
                left = mid + 1;
            } else {
                // nums[mid] == nums[right], can't decide → shrink right
                right--;
            }
        }

        return nums[left]; // or nums[right]
    }
}