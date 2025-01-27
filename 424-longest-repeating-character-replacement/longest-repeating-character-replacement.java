class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26]; // To store frequency of characters in the current window
        int left = 0; // Left pointer of the sliding window
        int maxFreq = 0; // Maximum frequency of any character in the window
        int maxLength = 0; // Result to store the length of the longest substring

        for (int right = 0; right < s.length(); right++) {
            // Increment the frequency of the current character
            freq[s.charAt(right) - 'A']++;

            // Update maxFreq
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // If the condition is violated, shrink the window
            while (right - left + 1 - maxFreq > k) {
                freq[s.charAt(left) - 'A']--; // Decrement the frequency of the left character
                left++; // Move the left pointer
            }

            // Update the maximum length of the window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}