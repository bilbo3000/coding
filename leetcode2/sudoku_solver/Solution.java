public class Solution {
    boolean stop = false;

    public void solveSudoku(char[][] board) {
        int [] coor = findFirstEmpty(board);
        int row = coor[0];
        int col = coor[1];

        if (row == -1 || col == -1) {
            stop = true;
            return;
        }

        int i = 1;

        while (!stop && i <= 9) {
            board[row][col] = (char)(i + '0');
            // System.out.println("check: " + check(board, row, col));
            if (check(board, row, col)) {
                solveSudoku(board);
            }

            i++;
        }

        if (!stop) {
            board[row][col] = '.';
        }
    }

    private boolean check(char[][] board, int row, int col) {
        int bit = 0;

        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] != '.') {
                int digit = (int)(board[row][j] - '0');

                if ((bit & (1 << digit)) != 0) return false;

                bit |= (1 << digit);
            }
        }

        // Check column
        bit = 0;

        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.') {
                int digit = (int)(board[i][col] - '0');

                if ((bit & (1 << digit)) != 0) return false;

                bit |= (1 << digit);
            }
        }

        // Check quad
        bit = 0;

        for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) {
            for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j++) {
                if (board[i][j] != '.') {
                    int digit = (int)(board[i][j] - '0');

                    if ((bit & (1 << digit)) != 0) return false;

                    bit |= (1 << digit);
                }
            }
        }

        return true;
    }

    private int[] findFirstEmpty(char[][] board) {
        int [] coor = new int[]{-1, -1};

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    coor[0] = i;
                    coor[1] = j;
                    return coor;
                }
            }
        }

        return coor;
    }
}
