class Solution {
    public String countAndSay(int n) {
        String result = "1"; 
        
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            char prev = result.charAt(0);
            int count = 1;
            
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == prev) {
                    count++;
                } else {
                    sb.append(count).append(prev);
                    prev = result.charAt(j);
                    count = 1;
                }
            }
            sb.append(count).append(prev); 
            result = sb.toString();
        }
        
        return result;
    }
}