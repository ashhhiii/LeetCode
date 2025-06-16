class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] startWithIndex = new int[n][2]; // [start, index]

        // Step 1: Store start points and their original indices
        for (int i = 0; i < n; i++) {
            startWithIndex[i][0] = intervals[i][0]; // start
            startWithIndex[i][1] = i;               // index
        }

        // Step 2: Sort based on start points
        Arrays.sort(startWithIndex, Comparator.comparingInt(a -> a[0]));

        int[] result = new int[n];

        // Step 3: For each interval, binary search the minimum start >= end
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int left = 0, right = n - 1;
            int idx = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (startWithIndex[mid][0] >= end) {
                    idx = startWithIndex[mid][1];
                    right = mid - 1; // search for smaller start >= end
                } else {
                    left = mid + 1;
                }
            }

            result[i] = idx;
        }

        return result;
    
    }
}