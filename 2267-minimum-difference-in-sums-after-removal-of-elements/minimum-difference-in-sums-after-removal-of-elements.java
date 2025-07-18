class Solution {
    public long minimumDifference(int[] nums) {
       int n = nums.length / 3;
        int len = nums.length;

        long[] leftSum = new long[len];
        long[] rightSum = new long[len];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long sumLeft = 0;
        
        for (int i = 0; i < len; i++) {
            sumLeft += nums[i];
            maxHeap.offer(nums[i]);

            if (maxHeap.size() > n) {
                sumLeft -= maxHeap.poll();
            }
            leftSum[i] = sumLeft;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sumRight = 0;
        
     
        for (int i = len - 1; i >= 0; i--) {
            sumRight += nums[i];
            minHeap.offer(nums[i]);

            if (minHeap.size() > n) {
                sumRight -= minHeap.poll();
            }
            rightSum[i] = sumRight;
        }

        long result = Long.MAX_VALUE;
        
      
        for (int i = n - 1; i < 2 * n; i++) {
            result = Math.min(result, leftSum[i] - rightSum[i + 1]);
        }

        return result;
    }
}