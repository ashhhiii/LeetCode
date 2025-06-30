class Solution {
    private static final int MOD = 1_000_000_007;

    public static int countGoodNumbers(long n) {
        // Calculate the number of even and odd indices
        long evenCount = (n + 1) / 2;  // Ceiling of n/2
        long oddCount = n / 2;         // Floor of n/2

        // Calculate 5^evenCount and 4^oddCount using modular exponentiation
        long evenPower = modularExponentiation(5, evenCount, MOD);
        long oddPower = modularExponentiation(4, oddCount, MOD);

        // Multiply the results modulo MOD
        return (int) ((evenPower * oddPower) % MOD);
    }

    private static long modularExponentiation(long base, long exp, int mod) {
        long result = 1;
        base = base % mod; // Ensure base is within mod

        while (exp > 0) {
            // If exp is odd, multiply the result by the base
            if ((exp % 2) == 1) {
                result = (result * base) % mod;
            }
            // Square the base and reduce the exponent by half
            base = (base * base) % mod;
            exp /= 2;
        }

        return result;
    }
    
}