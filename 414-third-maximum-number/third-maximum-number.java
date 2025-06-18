class Solution {
    public int thirdMax(int[] nums) {
    // Use a TreeSet to store distinct values in sorted order
        TreeSet<Integer> sortedSet = new TreeSet<>();
        for (int num : nums) {
            sortedSet.add(num);
            // Keep only the top 3 distinct values
            if (sortedSet.size() > 3) {
                sortedSet.pollFirst(); // Remove the smallest value
            }
        }

        // If there are less than 3 distinct values, return the maximum
        if (sortedSet.size() < 3) {
            return sortedSet.last();
        }

        // Otherwise, return the third maximum
        return sortedSet.first();
    }
}