class Solution {
    public long minOperations(int[][] queries) {
          long ans = 0;
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            long totalSteps = prefixSteps(r) - prefixSteps(l - 1);
            ans += (totalSteps + 1) / 2;
        }
        return ans;
    }

    private long prefixSteps(long n) {
        if (n <= 0) return 0;
        long sum = 0;
        long base = 1;
        int step = 1;

        while (base * 4 <= n) {
            long blockSize = base * 3; 
            sum += (long) step * blockSize;
            base *= 4;
            step++;
        }

        sum += (long) step * (n - base + 1);

        return sum;
    
    }
}