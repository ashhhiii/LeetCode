class Solution {
    public int numWays(String s) {
        int mod = 1_000_000_007;
        int n = s.length();
        int totalOnes = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }

        // Case 1: not divisible
        if (totalOnes % 3 != 0) return 0;

        // Case 2: all zeros
        if (totalOnes == 0) {
            long cuts = (long)(n - 1);
            return (int)((cuts * (cuts - 1) / 2) % mod);
        }

        // Case 3: divisible
        int onesPerPart = totalOnes / 3;
        long firstZeroes = 0, secondZeroes = 0;
        int onesCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') onesCount++;
            if (onesCount == onesPerPart) firstZeroes++;
            else if (onesCount == onesPerPart + 1) break;
        }

        onesCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') onesCount++;
            if (onesCount == 2 * onesPerPart) secondZeroes++;
            else if (onesCount == 2 * onesPerPart + 1) break;
        }

        return (int)((firstZeroes * secondZeroes) % mod);
    
    }
}