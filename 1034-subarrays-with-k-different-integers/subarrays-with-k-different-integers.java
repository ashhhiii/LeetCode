class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k) - atmost(nums,k-1);
    }
    private int atmost(int[] nums, int k){
        int left = 0;
        int count= 0 ;
        HashMap<Integer , Integer> countMap = new HashMap<>();

        for(int right = 0; right < nums.length; right++){
            countMap.put(nums[right] , countMap.getOrDefault(nums[right] , 0)+1);
        
        while(countMap.size() > k){
            countMap.put(nums[left] , countMap.get(nums[left]) -1);
            if(countMap.get(nums[left]) == 0){
                countMap.remove(nums[left]);
            }
            left++;
        }
        count += right - left +1;
    }
    return count;
    }
}