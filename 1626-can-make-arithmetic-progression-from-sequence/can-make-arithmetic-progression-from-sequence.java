class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
         Arrays.sort(arr);  // Sort the array

        int diff = arr[1] - arr[0];  // Common difference

        // Check if all consecutive differences are the same
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }

        return true;
    
    }
}