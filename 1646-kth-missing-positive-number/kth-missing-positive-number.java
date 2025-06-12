class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missing = 0;
        int current = 1;
        int index=0;

        while(true){
            if(index<arr.length && arr[index] == current){
                index++;
            }else{
                missing++;
                if(missing == k){
                    return current;
                }
            }
            current++;
        } 
    }
}