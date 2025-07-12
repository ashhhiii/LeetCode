class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int prefixSum = 0;
        int count = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);

        for (int num : nums) {
            prefixSum += num;

            if (countMap.containsKey(prefixSum - goal)) {
                count += countMap.get(prefixSum - goal);
            }

            countMap.put(prefixSum, countMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}