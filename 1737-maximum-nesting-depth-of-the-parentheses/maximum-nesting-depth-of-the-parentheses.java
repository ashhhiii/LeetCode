class Solution {
    public int maxDepth(String s) {
        int currentDepth =0 ;
        int MaxDepth = 0;

        for(char c:s.toCharArray()){
            if(c == '('){
                currentDepth++;
                MaxDepth = Math.max( MaxDepth, currentDepth);
            }
            else if(c==')'){
                currentDepth--;
            }
        }
        return MaxDepth;
    }
}