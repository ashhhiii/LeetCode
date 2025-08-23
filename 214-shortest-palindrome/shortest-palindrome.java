class Solution {
    public String shortestPalindrome(String s) {
       String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;
        
        int n = combined.length();
        int[] lps = new int[n];

        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        int longestPrefix = lps[n - 1];
        String suffix = s.substring(longestPrefix);
        return new StringBuilder(suffix).reverse().toString() + s;
    }
}