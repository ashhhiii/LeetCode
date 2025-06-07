class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
       PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int maxValue = Integer.MIN_VALUE;

        for (int[] point : points) {
            int x = point[0], y = point[1];

            // Remove points where xi is too far from current x
            while (!maxHeap.isEmpty() && x - maxHeap.peek()[1] > k) {
                maxHeap.poll();
            }

            if (!maxHeap.isEmpty()) {
                // current value = y + x + (max of (yi - xi))
                maxValue = Math.max(maxValue, y + x + maxHeap.peek()[0]);
            }

            // Push current point (yi - xi, xi)
            maxHeap.offer(new int[]{y - x, x});
        }

        return maxValue;
    }
}