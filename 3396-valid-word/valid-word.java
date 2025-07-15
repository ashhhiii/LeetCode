class Solution {
    public boolean isValid(String word) {
        if(word == null || word.length() < 3){
            return false;
        }
        boolean hasVowel = false;
        boolean hasCon = false;
        for(char ch : word.toCharArray()){
            if(!Character.isLetterOrDigit(ch)){
                return false;
            }
            if(isVowel(ch)){
                hasVowel = true;
            }else if(Character.isLetter(ch) && !isVowel(ch)){
                hasCon = true;
            }
        }
        return hasVowel && hasCon;
    }
    private boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        return ch =='a'||ch =='e'||ch=='i'||ch=='o' || ch=='u';
    }
}