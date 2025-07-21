class Solution {
    public String makeFancyString(String s) {
         StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            int len = result.length();
            
            // If the last two characters in result are same as s.charAt(i), skip it
            if (len >= 2 && result.charAt(len - 1) == s.charAt(i) && result.charAt(len - 2) == s.charAt(i)) {
                continue; // skip this character
            }
            
            result.append(s.charAt(i));
        }

        return result.toString();
    
    }
}