class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true; // Found the target
            }
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue;
            }

           if (nums[left] <= nums[mid]) { // Left part is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Target in left sorted part
                } else {
                    left = mid + 1; // Target in right unsorted part
                }
            } else { // Right part is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // Target in right sorted part
                } else {
                    right = mid - 1; // Target in left unsorted part
                }
            }
        }

        return false; // Target not found
    }
}
