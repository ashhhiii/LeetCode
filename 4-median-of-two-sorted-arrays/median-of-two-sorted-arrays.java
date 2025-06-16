class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;
        
        while (low <= high) {
            int partitionA = (low + high) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;
            
            int leftMaxA = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int rightMinA = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];
            
            int leftMaxB = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int rightMinB = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];
            
            // Check if partition is correct
            if (leftMaxA <= rightMinB && leftMaxB <= rightMinA) {
                // Calculate median
                if ((m + n) % 2 == 0) {
                    return (Math.max(leftMaxA, leftMaxB) + Math.min(rightMinA, rightMinB)) / 2.0;
                } else {
                    return Math.max(leftMaxA, leftMaxB);
                }
            } else if (leftMaxA > rightMinB) {
                // Move partitionA to the left
                high = partitionA - 1;
            } else {
                // Move partitionA to the right
                low = partitionA + 1;
            }
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted or invalid.");
    }
    

    
}