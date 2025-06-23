class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Expand around the current character for odd-length palindromes
            int len1 = expandAroundCenter(s, i, i);

            // Expand around the gap between two characters for even-length palindromes
            int len2 = expandAroundCenter(s, i, i + 1);

            // Get the maximum length of the palindrome from the two cases
            int len = Math.max(len1, len2);

            // Update the start and end pointers if we find a longer palindrome
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Return the length of the palindrome
        return right - left - 1;
    }
}