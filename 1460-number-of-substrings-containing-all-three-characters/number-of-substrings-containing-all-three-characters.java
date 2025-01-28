class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int left=0;
        int count=0;
        HashMap<Character,Integer> charCount = new HashMap<>();

        for(int right = 0;right<n;right++){
            char currentChar = s.charAt(right);
            charCount.put(currentChar,charCount.getOrDefault(currentChar,0)+1);
  while (charCount.getOrDefault('a', 0) > 0 &&
                   charCount.getOrDefault('b', 0) > 0 &&
                   charCount.getOrDefault('c', 0) > 0) {
                // Count valid substrings
                count += (n - right);

            char leftChar = s.charAt(left);
            charCount.put(leftChar,charCount.get(leftChar)-1);
            left++;
           }
            
        } 
        return count;
    }
}