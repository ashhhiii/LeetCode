class Solution {
    public int largestPerimeter(int[] nums) {
         Arrays.sort(nums);

        // Check for the largest valid triangle
        for (int i = nums.length - 3; i >= 0; i--) {
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                // Return the perimeter of the triangle
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }

        // No valid triangle found
        return 0;
    }
    
}