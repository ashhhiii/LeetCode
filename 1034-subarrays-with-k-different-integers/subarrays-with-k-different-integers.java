class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums,k-1);
    }
    private int atMost(int[] nums,int k){
        HashMap<Integer,Integer> countMap = new HashMap<>();
        int left=0;
        int subArray = 0;

        for(int right=0;right<nums.length;right++){
            countMap.put(nums[right],countMap.getOrDefault(nums[right],0)+1);
            
           while (countMap.size() > k) {
                countMap.put(nums[left], countMap.get(nums[left]) - 1);
                if (countMap.get(nums[left]) == 0) {
                    countMap.remove(nums[left]);
                }
                left++;
            }

        subArray +=right-left+1;
        }
        return subArray;
    }
}