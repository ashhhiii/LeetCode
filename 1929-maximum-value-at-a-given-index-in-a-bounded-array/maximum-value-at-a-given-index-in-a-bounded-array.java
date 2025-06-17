class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum, result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = mid + sumOfSide(mid - 1, index) + sumOfSide(mid - 1, n - index - 1);

            if (sum <= maxSum) {
                result = mid;  // valid, try higher
                left = mid + 1;
            } else {
                right = mid - 1;  // too big, try smaller
            }
        }

        return result;
    }

    // Sum of one side of the pyramid
    private long sumOfSide(int peak, int length) {
        if (peak >= length) {
            // Can fully decrease without hitting 1
            long first = peak - length + 1;
            return (long)(peak + first) * length / 2;
        } else {
            // Hits 1 before length ends
            long sum = (long)(peak + 1) * peak / 2;
            return sum + (length - peak);  // Remaining are 1s
        }
    
    }
}