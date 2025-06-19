class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
    
   // Step 2: Find the minimum absolute difference
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }
    List<List<Integer>> result = new ArrayList<>();
    for(int i =1;i<arr.length;i++){
        if(arr[i] - arr[i-1] == minDiff){
            result.add(Arrays.asList(arr[i-1],arr[i]));
        }
       
    }
     return result;
}
}