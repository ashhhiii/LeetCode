class Solution {
    public String longestCommonPrefix(String[] strs) {
       if (strs == null || strs.length == 0) {
            return "";
        }

        // Take the first string as the initial prefix
        String prefix = strs[0];

        // Compare the prefix with each string in the array
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                // Reduce the prefix
                prefix = prefix.substring(0, prefix.length() - 1);

                // If prefix becomes empty, return ""
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

}