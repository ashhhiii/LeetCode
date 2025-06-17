class Solution {
    public int maxFrequency(int[] nums, int k) {
         Arrays.sort(nums);
        int l = 0;
        long total = 0;
        int res = 0;

        for (int r = 0; r < nums.length; r++) {
            total += nums[r];

            // total operations needed to make all elements in window equal to nums[r]
            long required = (long) nums[r] * (r - l + 1);

            while (required - total > k) {
                total -= nums[l];
                l++;
                required = (long) nums[r] * (r - l + 1);
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    
    }
}