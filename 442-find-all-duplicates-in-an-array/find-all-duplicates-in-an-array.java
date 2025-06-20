class Solution {
    public List<Integer> findDuplicates(int[] nums) {
         List<Integer> result = new ArrayList<>();

        // Traverse and mark the index corresponding to each value as visited
        for (int num : nums) {
            int index = Math.abs(num) - 1; // Convert value to 0-based index
            if (nums[index] < 0) {
                // If already marked negative, it's a duplicate
                result.add(Math.abs(num));
            } else {
                // Mark as visited by negating the value
                nums[index] = -nums[index];
            }
        }

        return result;
    
    }
}