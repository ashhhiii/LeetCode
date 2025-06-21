class Solution {
    public String removeOuterParentheses(String s) {
      StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Add to result only if not outermost
                if (depth > 0) {
                    result.append(c);
                }
                depth++;
            } else if (c == ')') {
                depth--;
                // Add to result only if not outermost
                if (depth > 0) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}