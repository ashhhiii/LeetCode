class Solution {
    public List<String> addOperators(String num, int target) {
          List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        backtrack(result, "", num, target, 0, 0, 0);
        return result;
    }

    private static void backtrack(List<String> result, String path, String num, int target, int index, long currentValue, long lastValue) {
        // Base case: if we've reached the end of the string
        if (index == num.length()) {
            if (currentValue == target) {
                result.add(path);
            }
            return;
        }

        // Try all possible splits
        for (int i = index; i < num.length(); i++) {
            // Skip numbers with leading zeros
            if (i > index && num.charAt(index) == '0') {
                break;
            }

            // Get the current number as a substring
            String currentStr = num.substring(index, i + 1);
            long currentNum = Long.parseLong(currentStr);

            if (index == 0) {
                // First number, no operator to add
                backtrack(result, path + currentStr, num, target, i + 1, currentNum, currentNum);
            } else {
                // Add '+'
                backtrack(result, path + "+" + currentStr, num, target, i + 1, currentValue + currentNum, currentNum);

                // Add '-'
                backtrack(result, path + "-" + currentStr, num, target, i + 1, currentValue - currentNum, -currentNum);

                // Add '*'
                backtrack(result, path + "*" + currentStr, num, target, i + 1,
                        currentValue - lastValue + lastValue * currentNum, lastValue * currentNum);
            }
        }
    
    }
}