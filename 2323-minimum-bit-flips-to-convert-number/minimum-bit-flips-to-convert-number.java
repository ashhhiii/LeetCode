class Solution {
    public int minBitFlips(int start, int goal) {
         int xor = start ^ goal;
        int count = 0;

        // Count the number of 1s in the XOR result
        while (xor != 0) {
            count += xor & 1; // Increment count if the last bit is 1
            xor >>= 1;        // Right shift to check the next bit
        }

        return count;
    
    }
}