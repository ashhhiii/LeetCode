class Solution {
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0) {
            return triangle;
        }

        // Generate rows of Pascal's Triangle
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            // Each row starts and ends with 1
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Sum of the two numbers above
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(row);
        }

        return triangle;
    }
    
}