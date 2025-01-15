class Solution {
    public boolean exist(char[][] board, String word) {
         int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true; // Found the word
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false; // Out of bounds or character mismatch
        }

        char temp = board[row][col]; // Save the current cell
        board[row][col] = '#'; // Mark the cell as visited

        // Explore all four possible directions
        boolean found = backtrack(board, word, row + 1, col, index + 1)
                || backtrack(board, word, row - 1, col, index + 1)
                || backtrack(board, word, row, col + 1, index + 1)
                || backtrack(board, word, row, col - 1, index + 1);

        board[row][col] = temp; // Restore the cell
        return found;
    }
}