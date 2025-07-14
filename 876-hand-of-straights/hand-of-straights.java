class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
         TreeMap<Integer ,Integer> cardCount = new TreeMap<>();
         
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

         while(!cardCount.isEmpty()){
            int start = cardCount.firstKey();
            for(int i = start ; i < start + groupSize; i++){
                if(!cardCount.containsKey(i)){
                    return false;
                }
                cardCount.put(i , cardCount.get(i) -1);
            if(cardCount.get(i) == 0){
                cardCount.remove(i);
            }
            
            }
         }
         return true;
    }
}