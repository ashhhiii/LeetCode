class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int breakpoint = 0;

        for(int i =0;i<=n-1;i++){
            if(nums[i] > nums[(i+1)% n]){
                breakpoint++;
            }
            if(breakpoint>1){
                return false;
            }
            
        }
        return true;

    }
}