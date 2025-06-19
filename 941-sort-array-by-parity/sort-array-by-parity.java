class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        // Separate even and odd numbers
        for (int num : nums) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }

        // Combine even and odd numbers into a single array
        int[] result = new int[nums.length];
        int index = 0;

        for (int num : even) {
            result[index++] = num;
        }

        for (int num : odd) {
            result[index++] = num;
        }

        return result;
    }

    
}