class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals ==null ||intervals.length ==0){
            return intervals;
        }
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> mergedList = new ArrayList<>();
         for (int i = 0; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            boolean merged = false;
            for(int[] interval : mergedList){
             if (start <= interval[1]){
                interval[1] = Math.max(interval[1],end);
                merged = true;
                break;
            }
            }
            if(!merged){
                mergedList.add(new int[]{start,end});
            }
        }
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}