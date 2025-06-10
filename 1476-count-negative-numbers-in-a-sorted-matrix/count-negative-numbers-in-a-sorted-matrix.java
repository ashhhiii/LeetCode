class Solution {
    public int countNegatives(int[][] grid) {
          int count = 0;
        for (int[] row : grid) {
            int left = 0;
            int right = row.length - 1;
            int firstNegativeIndex = row.length; // Initialize to the end of the row
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (row[mid] < 0) {
                    firstNegativeIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
            count += row.length - firstNegativeIndex;
        }
        return count;
    
    }
}