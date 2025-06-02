class Solution {
    public int singleNumber(int[] nums) {
           int result = 0;
        
        // XOR all the numbers in the array
        for (int num : nums) {
            result ^= num; // XOR operation cancels out duplicate numbers
        }
        
        return result; // The remaining number is the single number
    }
    }
