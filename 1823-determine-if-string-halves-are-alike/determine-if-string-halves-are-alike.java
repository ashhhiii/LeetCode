class Solution {
    public boolean halvesAreAlike(String s) {
        int mid = s.length()/2;
        int count1 = 0;
        int count2 = 0;

       Set<Character> vowels = new HashSet<>();
        for (char ch : "aeiouAEIOU".toCharArray()) {
            vowels.add(ch);
        }

        for(int i=0; i< mid;i++){
            if(vowels.contains(s.charAt(i)))
            count1++;
        }
         for(int i=mid; i< s.length();i++){
            if(vowels.contains(s.charAt(i)))
            count2++;
        }
        return count1 ==count2;
    }

}