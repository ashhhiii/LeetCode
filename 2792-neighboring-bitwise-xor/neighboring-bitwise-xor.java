class Solution {
    public boolean doesValidArrayExist(int[] derived) {
         int n = derived.length;

        // Check for original[0] = 0
        if (isValidOriginal(derived, 0, n)) {
            return true;
        }

        // Check for original[0] = 1
        if (isValidOriginal(derived, 1, n)) {
            return true;
        }

        // No valid original array exists
        return false;
    }

    private static boolean isValidOriginal(int[] derived, int firstValue, int n) {
        int[] original = new int[n];
        original[0] = firstValue;

        // Derive the rest of the original array
        for (int i = 1; i < n; i++) {
            original[i] = derived[i - 1] ^ original[i - 1];
        }

        // Validate the last XOR relationship
        return (original[n - 1] ^ original[0]) == derived[n - 1];
    
    }
}