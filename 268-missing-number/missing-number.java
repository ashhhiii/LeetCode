class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2; // Sum of first n natural numbers
        int actualSum = 0;

        // Calculate the sum of elements in the array
        for (int num : nums) {
            actualSum += num;
        }

        // The missing number is the difference between expected and actual sums
        return expectedSum - actualSum;
    }
}