class Solution {
    public String sortSentence(String s) {
         String[] words = s.split(" ");
        String[] result = new String[words.length];

        for (String word : words) {
            // The last character is the position (1-indexed)
            int index = word.charAt(word.length() - 1) - '1'; // Convert to 0-based index
            result[index] = word.substring(0, word.length() - 1); // Remove the number
        }

        return String.join(" ", result);
    
    }
}