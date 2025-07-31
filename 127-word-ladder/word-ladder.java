class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;


        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i =0 ; i <size ; i++){
                String currentWord = queue.poll();

                for (int j = 0; j< currentWord.length();j++){
                    char[] wordArray = currentWord.toCharArray();
                    for (char c ='a' ; c <= 'z'; c++ ){
                        char oldChar = wordArray[j];
                        wordArray[j] = c;
                        String newWord = new String (wordArray);

                        if(newWord.equals(endWord)) return level+1;

                        if(wordSet.contains(newWord)){
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                        wordArray[j] = oldChar;
                    }

                }
            }
            level++;
        }
        return 0;
    }
}