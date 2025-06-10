class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
       int sumAlice = 0;
       int sumBob = 0;
       Set<Integer> bobSet = new HashSet<>();

       for(int num: aliceSizes){
        sumAlice += num;
       } 
       for(int num:  bobSizes){
        sumBob += num;
        bobSet.add(num);
       }
       int delta = (sumBob - sumAlice) /2;
        for( int  x : aliceSizes){
            int y = x + delta;
            if (bobSet.contains(y)) {
                return new int[]{x, y};
            }
        }
        return new int[0];
    }
}