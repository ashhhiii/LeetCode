class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int i = digits.length - 2;

        // Step 1: find first decreasing digit from right
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If no such index, then it's the last permutation
        if (i < 0) return -1;

        // Step 2: find just larger digit to the right
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: swap
        swap(digits, i, j);

        // Step 4: reverse suffix
        reverse(digits, i + 1, digits.length - 1);

        // Step 5: convert to number and check 32-bit range
        try {
            int val = Integer.parseInt(new String(digits));
            return val;
        } catch (NumberFormatException e) {
            return -1; // out of 32-bit int range
        }
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    
    }
}