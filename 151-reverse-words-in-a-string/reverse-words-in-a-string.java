class Solution {
    public String reverseWords(String s) {
      s = s.trim();

        // Step 2: Split the string into words
        String[] words = s.split("\\s+"); // Splits by one or more spaces

        // Step 3: Reverse the array of words
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) { // Add space between words
                reversed.append(" ");
            }
        }

        // Return the reversed string
        return reversed.toString();
    }
}