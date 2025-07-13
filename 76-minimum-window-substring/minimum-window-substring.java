class Solution {
    public String minWindow(String s, String t) {
         if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> windowFreq = new HashMap<>();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int validCount = 0;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (tFreq.containsKey(c)) {
                windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
                if (windowFreq.get(c).equals(tFreq.get(c))) {
                    validCount++;
                }
            }

            while (validCount == tFreq.size()) {
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);
                left++;

                if (tFreq.containsKey(leftChar)) {
                    if (windowFreq.get(leftChar).equals(tFreq.get(leftChar))) {
                        validCount--;
                    }
                    windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}