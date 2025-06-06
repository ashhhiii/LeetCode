class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> prefSum = new HashMap<>();
        prefSum.put(0,1);

        int count=0;
        int sum = 0;
        for(int num:nums){
            sum += num;
            
            if(prefSum.containsKey(sum-k)){
                count += prefSum.get(sum-k);
            }
            prefSum.put(sum,prefSum.getOrDefault(sum,0) + 1);
    }
    return count;
}
    
}