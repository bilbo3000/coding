public class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }

    private boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    boolean result = false;

                    for (int x = 0; x < 9; x++) {
                        char c = (char) (x + '1');
                        board[i][j] = c;

                        if (!checkRow(board, i)) {
                            continue;
                        }

                        if (!checkCol(board, j)) {
                            continue;
                        }

                        if (!checkQuad(board, i, j)) {
                            continue;
                        }

                        result = helper(board);

                        if (result) {
                            return true;
                        }
                    }

                    board[i][j] = '.';

                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkRow(char[][] board, int i) {
        boolean[] seen = new boolean[9];

        for (int j = 0; j < 9; j++) {
            char c = board[i][j];

            if (c != '.') {
                int index = (int) (c - '1');

                if (seen[index]) {
                    return false;
                }

                seen[index] = true;
            }
        }

        return true;
    }

    private boolean checkCol(char[][] board, int j) {
        boolean[] seen = new boolean[9];

        for (int i = 0; i < 9; i++) {
            char c = board[i][j];

            if (c != '.') {
                int index = (int) (c - '1');

                if (seen[index]) {
                    return false;
                }

                seen[index] = true;
            }
        }

        return true;
    }

    private boolean checkQuad(char[][] board, int i, int j) {
        boolean[] seen = new boolean[9];

        for (int a = i / 3 * 3; a < i / 3 * 3 + 3; a++) {
            for (int b = j / 3 * 3; b < j / 3 * 3 + 3; b++) {
                char c = board[a][b];

                if (c != '.') {
                    int index = (int) (c - '1');

                    if (seen[index]) {
                        return false;
                    }

                    seen[index] = true;
                }
            }
        }

        return true;
    }
}
