class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }

        int[] result = new int[nums.length];
        int evenIndex = 0; // Pointer for even indices
        int oddIndex = 1;  // Pointer for odd indices

        for (int num : nums) {
            if (num % 2 == 0) {
                // Place even number at the next available even index
                result[evenIndex] = num;
                evenIndex += 2;
            } else {
                // Place odd number at the next available odd index
                result[oddIndex] = num;
                oddIndex += 2;
            }
        }
        return result;
    }
}