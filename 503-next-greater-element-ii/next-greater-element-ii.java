class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(result,-1);
    
    
    for (int i = 0; i < 2 * n; i++) {
        int currentIndex = i%n;
        while (!stack.isEmpty() && nums[stack.peek()] < nums[currentIndex]){
            result[stack.pop()] = nums[currentIndex];
        }
        if(i<n){
            stack.push(currentIndex);
        }
    }
    return result;
}
}