class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChild =0;
        int cookieSize = 0;
        while(contentChild<g.length && cookieSize < s.length){
            if(s[cookieSize] >= g[contentChild]){
                contentChild++;
            }
            cookieSize++;

        }
         return contentChild;
    }
}