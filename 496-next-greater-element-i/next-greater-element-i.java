class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        // map: value in nums2  -> its next‑greater value (or –1)
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();   // faster than Stack

        // 1️⃣  Build the map for all elements of nums2
        for (int num : nums2) {
            // While the current num is the “next greater” for stack top
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }
        // Anything still on the stack has no greater element
        while (!stack.isEmpty()) {
            nextGreater.put(stack.pop(), -1);
        }

        // 2️⃣  Fill the answer for nums1 using the map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}