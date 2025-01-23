class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
         Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        // Stack to help find the next greater element
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through nums2
        for (int num : nums2) {
            // Ensure the top of the stack is smaller than the current number
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            // Push the current number onto the stack
            stack.push(num);
        }
        
        // Any elements left in the stack have no greater element
        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }
        
        // Build the result array for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }
        
        return result;
    }
}