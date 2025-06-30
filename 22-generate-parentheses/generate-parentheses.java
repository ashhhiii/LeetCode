class Solution {
    public List<String> generateParenthesis(int n) {
         List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    // Helper function to recursively generate parentheses
    private static void generate(List<String> result, String current, int open, int close, int max) {
        // Base case: If the current string has reached the maximum length
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // If the number of open parentheses is less than max, add '('
        if (open < max) {
            generate(result, current + "(", open + 1, close, max);
        }

        // If the number of close parentheses is less than open, add ')'
        if (close < open) {
            generate(result, current + ")", open, close + 1, max);
        }
    }
}