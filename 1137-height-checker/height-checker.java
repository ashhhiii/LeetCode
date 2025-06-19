class Solution {
    public int heightChecker(int[] heights) {
     if (heights == null || heights.length == 0) {
            return 0; // No students to compare
        }
        
        // Create a sorted copy of the heights array
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);

        // Count mismatches
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }

        return count;
    }
}