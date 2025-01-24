class Solution {
    public int largestRectangleArea(int[] heights) {
     Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            // Pop from stack and calculate area when current height is less than the height of the stack's top.
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                max = getMax(heights, stack, max, i);
            }
            stack.push(i);
        }

        // Handle remaining elements in the stack.
        int i = heights.length;
        while (!stack.isEmpty()) {
            max = getMax(heights, stack, max, i);
        }

        return max;
    }

    private static int getMax(int[] arr, Stack<Integer> stack, int max, int i) {
        int area;
        int popped = stack.pop();
        if (stack.isEmpty()) {
            area = arr[popped] * i;
        } else {
            area = arr[popped] * (i - 1 - stack.peek());
        }
        return Math.max(max, area);
    }
}