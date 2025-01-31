class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
     if (hand.length % groupSize != 0) {
            return false; // If the total cards cannot be divided into groups, return false.
        }

        // Step 1: Count the occurrences of each card using a TreeMap
        TreeMap<Integer, Integer> cardCount = new TreeMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        // Step 2: Process the cards in ascending order
        while (!cardCount.isEmpty()) {
            int start = cardCount.firstKey(); // Get the smallest card value
            for (int i = start; i < start + groupSize; i++) {
                if (!cardCount.containsKey(i)) {
                    return false; // If a required card is missing, return false
                }
                // Decrease the count of the card
                cardCount.put(i, cardCount.get(i) - 1);
                if (cardCount.get(i) == 0) {
                    cardCount.remove(i); // Remove the card if its count becomes zero
                }
            }
        }

        return true; // All cards can be grouped successfully
    }
}