class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;

        // Calculate the total sum of the array
        for (int point : cardPoints) {
            totalSum += point;
        }

        // Edge case: if k == n, take all cards
        if (k == n) {
            return totalSum;
        }

        // Find the minimum sum of a subarray of size (n - k)
        int windowSize = n - k;
        int minSubarraySum = 0;
        int currentSubarraySum = 0;

        // Initialize the first window
        for (int i = 0; i < windowSize; i++) {
            currentSubarraySum += cardPoints[i];
        }
        minSubarraySum = currentSubarraySum;

        // Slide the window
        for (int i = windowSize; i < n; i++) {
            currentSubarraySum += cardPoints[i] - cardPoints[i - windowSize];
            minSubarraySum = Math.min(minSubarraySum, currentSubarraySum);
        }

        // The maximum score is the total sum minus the minimum subarray sum
        return totalSum - minSubarraySum;
    }

}