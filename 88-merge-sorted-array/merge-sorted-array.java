class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Use three pointers to merge nums1 and nums2
        int i = m - 1; // Pointer for the last element in the initialized part of nums1
        int j = n - 1; // Pointer for the last element in nums2
        int k = m + n - 1; // Pointer for the last position in nums1

        // Start merging from the back
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If any elements remain in nums2, copy them to nums1
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}