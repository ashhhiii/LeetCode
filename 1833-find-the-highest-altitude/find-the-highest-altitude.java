class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int CurrentAltitude = 0;

        for(int g : gain){
           CurrentAltitude += g; 
          maxAltitude = Math.max(maxAltitude, CurrentAltitude);
        }
        return  maxAltitude ;
    }
}