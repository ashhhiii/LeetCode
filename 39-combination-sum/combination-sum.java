class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>> result = new ArrayList<>();
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
            // Skip if candidate exceeds the target
            if (candidates[i] > target) continue;

            // Choose the candidate
            current.add(candidates[i]);
            // Explore with the current candidate (allowing repetition)
            backtrack(candidates, target - candidates[i], i, current, result);
            // Backtrack: remove the last element
            current.remove(current.size() - 1);
        }
    }
}