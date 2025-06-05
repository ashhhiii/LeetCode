class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // To store the maximum subarray sum
        int currentSum = 0;            // To store the current running sum

        for (int num : nums) {
            currentSum += num;

            // Update maxSum if currentSum is greater
            maxSum = Math.max(maxSum, currentSum);

            // Reset currentSum if it drops below 0
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

}