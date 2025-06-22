class Solution {
    public String reverseWords(String s) {
          String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            // Reverse each word
            StringBuilder reversed = new StringBuilder(word);
            result.append(reversed.reverse().toString()).append(" ");
        }

        // Remove the trailing space
        return result.toString().trim();
    }
}