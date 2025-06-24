class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int repeatCount = 0;
        
        // Keep appending a until sb.length >= b.length
        while (sb.length() < b.length()) {
            sb.append(a);
            repeatCount++;
        }
        
        // First try
        if (sb.indexOf(b) != -1) return repeatCount;
        
        // Try one more repeat
        sb.append(a);
        if (sb.indexOf(b) != -1) return repeatCount + 1;
        
        // Try one more (in case b spans 3 parts of a)
        sb.append(a);
        if (sb.indexOf(b) != -1) return repeatCount + 2;
        
        return -1;
    
    }
}