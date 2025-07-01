class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList)); // Add the current subset
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]); // Include the current element
            backtrack(result, tempList, nums, i + 1); // Recur with the next element
            tempList.remove(tempList.size() - 1); // Remove the current element to explore other subsets
        }
    }
}