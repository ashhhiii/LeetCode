class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
         int prefixSum = 0;
        int count = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1); // To handle subarrays that start from the beginning

        for (int num : nums) {
            prefixSum += num;

            // Check if prefixSum - goal exists in the map
            if (countMap.containsKey(prefixSum - goal)) {
                count += countMap.get(prefixSum - goal);
            }

            // Update the frequency of the current prefixSum
            countMap.put(prefixSum, countMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}