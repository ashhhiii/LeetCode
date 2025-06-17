class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
       int MOD = 1_000_000_007;
        int n = nums1.length;
        int[] sorted = Arrays.copyOf(nums1, n);
        Arrays.sort(sorted);

        long total = 0;
        int maxGain = 0;

        for (int i = 0; i < n; i++) {
            int a = nums1[i], b = nums2[i];
            int currDiff = Math.abs(a - b);
            total += currDiff;

            // Binary search for closest number to nums2[i]
            int closest = findClosest(sorted, b);
            int potentialDiff = Math.abs(closest - b);

            maxGain = Math.max(maxGain, currDiff - potentialDiff);
        }

        return (int)((total - maxGain + MOD) % MOD);
    }

    // Binary search to find closest element to target in sorted array
    private int findClosest(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int closest = arr[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (Math.abs(arr[mid] - target) < Math.abs(closest - target)) {
                closest = arr[mid];
            } else if (Math.abs(arr[mid] - target) == Math.abs(closest - target) && arr[mid] < closest) {
                closest = arr[mid]; // prefer smaller value in tie
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return closest;
     
    }
}