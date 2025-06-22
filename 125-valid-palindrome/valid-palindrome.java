class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int start = 0; // Pointer to the start of the string
        int end = s.length() - 1; // Pointer to the end of the string

        // Compare characters from start and end
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false; // If mismatch found, not a palindrome
            }
            start++; // Move start pointer forward
            end--; // Move end pointer backward
        }

        return true; // If no mismatch, it's a palindrome
    }
}