class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
         List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        // Sort the array to simplify finding unique quadruplets
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            // Avoid duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                // Avoid duplicates for the second element
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l]; // Use long to prevent overflow
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        // Avoid duplicates for the third and fourth elements
                        while (k < l && nums[k] == nums[k + 1]) k++;
                        while (k < l && nums[l] == nums[l - 1]) l--;

                        k++;
                        l--;
                    } else if (sum < target) {
                        k++; // Increase the sum
                    } else {
                        l--; // Decrease the sum
                    }
                }
            }
        }

        return result;
    }
}