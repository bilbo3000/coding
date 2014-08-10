public class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }

    private boolean helper(char[][] board) {
        boolean found = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!found) {
                    if (board[i][j] == '.') {
                        found = true;
                        for (char c = '1'; c <= '9'; c++) {
                            board[i][j] = c;
                            if (checkRow(board, i) && checkCol(board, j) && checkQuad(board, i, j)) {
                                boolean result = helper(board);

                                if (result) {
                                    return true;
                                }
                            }
                        }

                        board[i][j] = '.';
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean checkRow(char[][] board, int row) {
        boolean[] seen = new boolean[9];

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == '.') {
                continue;
            }

            if (seen[board[row][i] - '1']) {
                return false;
            } else {
                seen[board[row][i] - '1'] = true;
            }
        }

        return true;
    }

    private boolean checkCol(char[][] board, int col) {
        boolean[] seen = new boolean[9];

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == '.') {
                continue;
            }

            if (seen[board[i][col] - '1']) {
                return false;
            } else {
                seen[board[i][col] - '1'] = true;
            }
        }

        return true;
    }

    private boolean checkQuad(char[][] board, int row, int col) {
        boolean[] seen = new boolean[9];
        int rowOffset = row / 3;
        int colOffset = col / 3;

        for (int i = rowOffset * 3; i < rowOffset * 3 + 3; i++) {
            for (int j = colOffset * 3; j < colOffset * 3 + 3; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (seen[board[i][j] - '1']) {
                    return false;
                } else {
                    seen[board[i][j] - '1'] = true;
                }
            }
        }

        return true;
    }
}
