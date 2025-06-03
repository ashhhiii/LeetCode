class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> letter = new HashSet<>();
        for(char ch : sentence.toCharArray()){
            letter.add(ch);
        }
        return letter.size() == 26;
    }
}