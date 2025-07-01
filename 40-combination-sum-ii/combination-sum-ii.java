class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result) {
        // Base case: if target becomes 0, add current combination to the result
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Iterate through candidates starting from 'index'
        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Skip if candidate exceeds the target
            if (candidates[i] > target) {
                break;
            }

            // Choose the candidate
            current.add(candidates[i]);
            // Explore further with the next index
            backtrack(candidates, target - candidates[i], i + 1, current, result);
            // Backtrack: remove the last element
            current.remove(current.size() - 1);
        }
    }
    
}