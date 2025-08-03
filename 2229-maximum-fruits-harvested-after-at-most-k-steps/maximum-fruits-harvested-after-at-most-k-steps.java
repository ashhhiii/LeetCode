class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
         int n = fruits.length;
        int[] positions = new int[n];
        int[] amounts = new int[n];

        for (int i = 0; i < n; i++) {
            positions[i] = fruits[i][0];
            amounts[i] = fruits[i][1];
        }
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + amounts[i];
        }

        int result = 0;

        for (int leftSteps = 0; leftSteps <= k; leftSteps++) {
            int leftPos = startPos - leftSteps;
            if (leftPos < 0) break;

            int remainingSteps = k - 2 * leftSteps;

            if (remainingSteps < 0) continue;

            int rightPos = startPos + remainingSteps;

            int l = lowerBound(positions, leftPos);
            int r = upperBound(positions, rightPos) - 1;

            if (l <= r) {
                int total = prefix[r + 1] - prefix[l];
                result = Math.max(result, total);
            }
        }

    
        for (int rightSteps = 0; rightSteps <= k; rightSteps++) {
            int rightPos = startPos + rightSteps;
            if (rightPos > 200000) break;

            int remainingSteps = k - 2 * rightSteps;
            if (remainingSteps < 0) continue;

            int leftPos = startPos - remainingSteps;

            int l = lowerBound(positions, leftPos);
            int r = upperBound(positions, rightPos) - 1;

            if (l <= r) {
                int total = prefix[r + 1] - prefix[l];
                result = Math.max(result, total);
            }
        }

        return result;
    }

    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) high = mid;
            else low = mid + 1;
        }
        return low;
    }

  
    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}