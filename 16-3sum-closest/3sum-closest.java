class Solution {
    public int threeSumClosest(int[] nums, int target) {
       Arrays.sort(nums); // Step 1: Sort the array
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize with the first 3 elements

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            // Two-pointer approach
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // Update closestSum if currentSum is closer to target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Move pointers based on comparison
                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    // Exact match found
                    return target;
                }
            }
        }

        return closestSum;
     
    }
}