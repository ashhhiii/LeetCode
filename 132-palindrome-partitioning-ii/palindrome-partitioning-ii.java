class Solution {
    public int minCut(String s) {
       int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int[] minCuts = new int[n];

        for (int end = 0; end < n; end++) {
            int min = end; 
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) &&
                    (end - start <= 2 || isPalindrome[start + 1][end - 1])) {
                    
                    isPalindrome[start][end] = true;

                    if (start == 0) {
                        min = 0; 
                        
                    } else {
                        min = Math.min(min, minCuts[start - 1] + 1);
                    }
                }
            }
            minCuts[end] = min;
        }

        return minCuts[n - 1];
    }
}