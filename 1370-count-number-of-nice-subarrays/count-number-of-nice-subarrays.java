class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0 ;
         int currentSum = 0;
         HashMap<Integer , Integer> countMap = new HashMap<>();
         countMap.put(0,1);

         for( int num: nums){
            currentSum += num %2;
            if(countMap.containsKey(currentSum - k)){
                count += countMap.get(currentSum - k);
            }
            countMap.put(currentSum, countMap.getOrDefault(currentSum, 0) + 1);
         }
         return count;

    }
}