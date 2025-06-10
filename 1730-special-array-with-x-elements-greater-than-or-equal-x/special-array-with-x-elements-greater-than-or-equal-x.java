class Solution {
    public int specialArray(int[] nums) {
           Arrays.sort(nums);
        int n = nums.length;
        for (int x = 1; x <= n; x++) {
            int left = 0, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= x) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int count = n - left;
            if (count == x) {
                return x;
            }
        }
        return -1;
    
    }
}