class Solution {
    public int countPrimes(int n) {
         if (n <= 1) return 0;

        // Create a boolean array to track prime numbers
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true); // Assume all numbers are prime initially
        isPrime[0] = false; // 0 is not prime
        if (n > 1) isPrime[1] = false; // 1 is not prime

        // Apply Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false; // Mark multiples of i as non-prime
                }
            }
        }

        // Count the prime numbers
        int count = 0;
        for (boolean prime : isPrime) {
            if (prime) count++;
        }
        return count;
    
    }
}