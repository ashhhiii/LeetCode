class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;
        
        // Arrays to store Previous Less Element (PLE) and Next Less Element (NLE)
        int[] ple = new int[n];
        int[] nle = new int[n];
        
        // Monotonic stack for PLE
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            ple[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        // Clear the stack for NLE
        stack.clear();
        
        // Monotonic stack for NLE
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            nle[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        // Calculate the sum of contributions
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long count = (long)(i - ple[i]) * (nle[i] - i);
            sum = (sum + arr[i] * count) % MOD;
        }
        
        
        return (int) sum;
    
    }
}