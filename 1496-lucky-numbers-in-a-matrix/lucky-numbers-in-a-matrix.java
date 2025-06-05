class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
         List<Integer> result = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            // Find minimum in the current row and its column index
            int minVal = matrix[i][0];
            int minCol = 0;

            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                    minCol = j;
                }
            }

            // Check if minVal is the maximum in its column
            boolean isMaxInCol = true;
            for (int k = 0; k < rows; k++) {
                if (matrix[k][minCol] > minVal) {
                    isMaxInCol = false;
                    break;
                }
            }

            if (isMaxInCol) {
                result.add(minVal);
            }
        }

        return result;
    
    }
}