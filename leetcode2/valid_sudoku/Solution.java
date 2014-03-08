public class Solution {
    boolean checkRow(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int row = 0;

            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int val = (int)(board[i][j] - '0');
                if ((row & (1 << val)) != 0) return false;
                row |= 1 << val;
            }
        }

        return true;
    }

    boolean checkCol(char[][] board) {
        for (int j = 0; j < 9; j++) {
            int col = 0;

            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') continue;
                int val = (int)(board[i][j] - '0');
                if ((col & (1 << val)) != 0) return false;
                col |= 1 << val;
            }
        }

        return true;
    }

    boolean checkQuad(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int quad = 0;
                for (int y = i * 3; y < i * 3 + 3; y++) {
                    for (int x = j * 3; x < j * 3 + 3; x++) {
                        if (board[y][x] == '.') continue;
                        int val = (int)(board[y][x] - '0');
                        if ((quad & (1 << val)) != 0) return false;
                        quad |= 1 << val;
                    }
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        if (checkRow(board) && checkCol(board) && checkQuad(board)) return true;

        return false;
    }
}
