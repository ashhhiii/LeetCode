class Solution {
    public int jump(int[] nums) {
        int jump =0 , maxReach = 0, currentReach = 0;

        for( int i = 0; i< nums.length-1 ;i++){
            maxReach = Math.max(maxReach , nums[i]+i);

            if( i == currentReach){
                jump++;
                currentReach = maxReach;

                if(currentReach > nums.length-1){
                    break;
                }
            }
        }
        return jump;
    }
}