class Solution {
    public void solveSudoku(char[][] board) {
          solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    // Try placing digits 1-9 in the empty cell
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c; // Place the digit

                            // Recursively try to solve the next cells
                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack if the current digit doesn't lead to a solution
                            board[row][col] = '.';
                        }
                    }
                    return false; // No valid digit found for this cell
                }
            }
        }
        return true; // All cells are filled successfully
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        // Check if placing c at board[row][col] violates Sudoku rules

        // Check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) {
                return false;
            }
        }

        // Check 3x3 sub-grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }

        return true;
    
    }
}