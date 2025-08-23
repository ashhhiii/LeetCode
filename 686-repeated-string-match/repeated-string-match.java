class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int repeatCount = 0;
 
        while (sb.length() < b.length()) {
            sb.append(a);
            repeatCount++;
        }
  
        if (sb.indexOf(b) != -1) return repeatCount;
    
        sb.append(a);
        if (sb.indexOf(b) != -1) return repeatCount + 1;
  
        sb.append(a);
        if (sb.indexOf(b) != -1) return repeatCount + 2;
        
        return -1;
    
    }
}