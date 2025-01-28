class Solution {
    public String minWindow(String s, String t) {
       if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        // Frequency map for characters in t
        HashMap<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        // Sliding window variables
        HashMap<Character, Integer> windowFreq = new HashMap<>();
        int left = 0, right = 0, validCount = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            // Expand the window by including the character at `right`
            char c = s.charAt(right);
            right++;
            if (tFreq.containsKey(c)) {
                windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
                if (windowFreq.get(c).equals(tFreq.get(c))) {
                    validCount++;
                }
            }

            // Try shrinking the window when all characters are matched
            while (validCount == tFreq.size()) {
                // Update the result if the current window is smaller
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }

                // Shrink the window from the left
                char d = s.charAt(left);
                left++;
                if (tFreq.containsKey(d)) {
                    if (windowFreq.get(d).equals(tFreq.get(d))) {
                        validCount--;
                    }
                    windowFreq.put(d, windowFreq.get(d) - 1);
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

}