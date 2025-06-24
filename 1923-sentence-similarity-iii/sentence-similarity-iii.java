class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        
        // Ensure words1 is the longer or same length sentence
        if (words1.length < words2.length) {
            String[] temp = words1;
            words1 = words2;
            words2 = temp;
        }

        int i = 0;
        // match prefix
        while (i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }

        int j = 0;
        // match suffix
        while (j < words2.length - i &&
               words1[words1.length - 1 - j].equals(words2[words2.length - 1 - j])) {
            j++;
        }

        // if total matched = total words in shorter sentence
        return i + j == words2.length;
    
    }
}