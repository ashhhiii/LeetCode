class Solution {
    public double myPow(double x, int n) {
    if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }

        // If n is negative, convert x to 1/x and n to positive
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        // Calculate the power using recursion
        return powerHelper(x, n);
    }

    private static double powerHelper(double x, int n) {
        // Base case: any number raised to 0 is 1
        if (n == 0) {
            return 1.0;
        }

        // Recursively calculate x^(n/2)
        double half = powerHelper(x, n / 2);

        // If n is even: x^n = (x^(n/2))^2
        // If n is odd: x^n = x * (x^(n/2))^2
        return (n % 2 == 0) ? half * half : half * half * x;
    }  
    
}