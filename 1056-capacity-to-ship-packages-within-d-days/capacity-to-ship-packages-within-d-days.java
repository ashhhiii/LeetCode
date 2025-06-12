class Solution {
    public int shipWithinDays(int[] weights, int days) {
      int left = getMax(weights); // Minimum capacity
        int right = getSum(weights); // Maximum capacity

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                right = mid; // Try smaller capacity
            } else {
                left = mid + 1; // Increase capacity
            }
        }
        return left; // or right, as they will converge
    }

    // Helper function to determine if shipping is possible with given capacity
    private boolean canShip(int[] weights, int days, int capacity) {
        int dayCount = 1; // Start with 1 day
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                dayCount++; // Start a new day
                currentLoad = 0;
            }
            currentLoad += weight;

            if (dayCount > days) {
                return false; // Exceeded the allowed days
            }
        }
        return true;
    }

    // Helper function to find the maximum element in the array
    private int getMax(int[] weights) {
        int max = weights[0];
        for (int weight : weights) {
            if (weight > max) {
                max = weight;
            }
        }
        return max;
    }

    // Helper function to calculate the sum of elements in the array
    private int getSum(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }
}