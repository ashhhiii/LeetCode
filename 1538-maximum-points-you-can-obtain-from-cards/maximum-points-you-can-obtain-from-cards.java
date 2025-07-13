class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;

        for(int point : cardPoints){
            totalSum += point;
        }
        if(k==n){
            return totalSum;
        }
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
        return totalSum - minSubarraySum;
    } 
}