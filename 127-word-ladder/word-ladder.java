class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0; // If endWord is not in list, no transformation possible

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        int level = 1; // Start with level 1 (beginWord itself)
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                
                // Generate all possible words by changing one letter at a time
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] wordArray = currentWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        char oldChar = wordArray[j];
                        wordArray[j] = c;
                        String newWord = new String(wordArray);

                        if (newWord.equals(endWord)) return level + 1; // Found the shortest path

                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord); // Remove to prevent revisiting
                        }
                        
                        wordArray[j] = oldChar; // Restore original word
                    }
                }
            }
            level++; // Move to the next level
        }
        
        return 0; // If we exhaust the queue, transformation is not possible
    }
}