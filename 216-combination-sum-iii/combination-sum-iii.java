class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
         List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int k, int target, int start) {
        if (target == 0 && tempList.size() == k) {
            result.add(new ArrayList<>(tempList)); // Add the valid combination
            return;
        }
        if (tempList.size() >= k || target < 0) {
            return; // Stop further recursion if size exceeds k or target goes negative
        }

        for (int i = start; i <= 9; i++) {
            tempList.add(i); // Include the current number
            backtrack(result, tempList, k, target - i, i + 1); // Recur with the remaining target and next number
            tempList.remove(tempList.size() - 1); // Remove the last number to backtrack
        }
    }
    
}