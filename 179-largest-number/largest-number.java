class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Step 2: Sort with custom comparator
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        // Why b+a vs a+b? Ensures the bigger combination comes first

        // Step 3: Edge case - if largest is "0", return "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Step 4: Build the result string
        StringBuilder result = new StringBuilder();
        for (String s : strNums) {
            result.append(s);
        }

        return result.toString();
    
    }
}