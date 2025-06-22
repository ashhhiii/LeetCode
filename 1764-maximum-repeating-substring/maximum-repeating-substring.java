class Solution {
    public int maxRepeating(String sequence, String word) {
         int maxCount = 0;
        StringBuilder repeated = new StringBuilder(word);

        while (sequence.contains(repeated.toString())) {
            maxCount++;
            repeated.append(word);
        }

        return maxCount;
    }
}