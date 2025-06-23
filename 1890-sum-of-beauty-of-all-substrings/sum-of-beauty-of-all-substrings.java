class Solution {
    public int beautySum(String s) {
      int totalBeauty = 0;

        // Iterate over all starting points of substrings
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26]; // Frequency array for characters 'a' to 'z'
            for (int j = i; j < s.length(); j++) {
                // Update frequency for the current character
                freq[s.charAt(j) - 'a']++;

                // Calculate the beauty of the current substring
                totalBeauty += calculateBeauty(freq);
            }
        }

        return totalBeauty;
    }

    private static int calculateBeauty(int[] freq) {
        int maxFreq = 0;
        int minFreq = Integer.MAX_VALUE;

        for (int count : freq) {
            if (count > 0) {
                maxFreq = Math.max(maxFreq, count);
                minFreq = Math.min(minFreq, count);
            }
        }

        return maxFreq - minFreq;
    }
}