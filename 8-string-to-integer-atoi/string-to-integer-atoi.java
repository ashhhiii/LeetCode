class Solution {
    public int myAtoi(String s) {
        // Step 1: Trim leading and trailing whitespace
        s = s.trim();
        if (s.isEmpty()) return 0;

        // Step 2: Initialize variables
        int i = 0, n = s.length();
        int sign = 1;
        long result = 0;

        // Step 3: Check for a sign
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 4: Process numeric characters
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            if (result * sign <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (result * sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            i++;
        }

        // Step 5: Apply sign and return result
        return (int) (result * sign);
    
    }
}