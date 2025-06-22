class Solution {
    public String convertToTitle(int columnNumber) {
   StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // Adjust for 1-based indexing
            int remainder = columnNumber % 26;
            char letter = (char) ('A' + remainder); // Get the corresponding letter
            result.append(letter);
            columnNumber /= 26; // Move to the next position
        }

        return result.reverse().toString(); // Reverse the string for correct order
    }

   
}