class Solution {
    public int majorityElement(int[] nums) {
        // Phase 1: Find the candidate for the majority element
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Phase 2: Verify the candidate (optional, as the problem guarantees a majority element)
    

        // Return the majority element
        return candidate;
    }
}
