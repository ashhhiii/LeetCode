class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 2 != 0) {
                return false; // If not divisible by 2, it's not a power of 2
            }
            n /= 2; // Divide by 2 to check the next power
        }
        return true; // Reached 1, so it's a power of 2
    }
}