class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
     if (bloomDay.length < m * k) {
            return -1;
        }

        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;

        // Determine the range of days
        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        int result = -1;

        // Binary search on days
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canMakeBouquets(bloomDay, m, k, mid)) {
                result = mid; // Update the result
                right = mid - 1; // Try for earlier days
            } else {
                left = mid + 1; // Try for later days
            }
        }

        return result;
    }

    // Helper function to check if we can make m bouquets in d days
    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int d) {
        int bouquets = 0;
        int flowers = 0;

        for (int day : bloomDay) {
            if (day <= d) {
                flowers++; // Flower bloomed
                if (flowers == k) {
                    bouquets++;
                    flowers = 0; // Reset for next bouquet
                }
            } else {
                flowers = 0; // Reset if flower hasn't bloomed
            }

            if (bouquets >= m) {
                return true; // Early return if we meet the requirement
            }
        }

        return false; // Not enough bouquets
    }
}