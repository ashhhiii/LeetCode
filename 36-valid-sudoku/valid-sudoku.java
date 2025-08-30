class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9]; 

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.' ) continue;
                int d = ch - '1'; // 0..8
                if (d < 0 || d > 8) return false;

                if (rows[r][d]) return false;
                rows[r][d] = true;

                if (cols[c][d]) return false;
                cols[c][d] = true;

                int boxIndex = (r / 3) * 3 + (c / 3);
                if (boxes[boxIndex][d]) return false;
                boxes[boxIndex][d] = true;
            }
        }
        return true;
    }
}