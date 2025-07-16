class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for( int i = 0; i< nums.length ;i++){
            if( i > maxReach){
                return false;
            }
            maxReach = Math.max( maxReach , nums[i] +i);
            if( maxReach >= nums.length -1){
                return  true;
            }
    }
    return true;
    }
}