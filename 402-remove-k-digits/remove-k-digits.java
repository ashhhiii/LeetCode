class Solution {
    public String removeKdigits(String num, int k) {
         if (k == num.length()) return "0";

        // Use a stack to build the smallest possible number
        Deque<Character> stack = new ArrayDeque<>();

        for (char digit : num.toCharArray()) {
            // Remove digits from the stack if they are greater than the current digit
            // and we still need to remove more digits
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.pollLast();
                k--;
            }
            stack.addLast(digit);
        }

        // Remove any remaining digits from the end if k > 0
        while (k > 0) {
            stack.pollLast();
            k--;
        }

        // Build the result from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pollFirst());
        }

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    
    }
}