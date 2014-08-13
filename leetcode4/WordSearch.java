public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;

        if (m == 0) {
            return false;
        }

        int n = board[0].length;

        if (n == 0) {
            return false;
        }

        int len = word.length();

        if (len == 0) {
            return false;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean result = helper(board, word, 0, i, j);

                    if (result) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean helper(char[][] board, String word, int index, int i, int j) {
        int len = word.length();
        int m = board.length;
        int n = board[0].length;

        if (index == len) {
            return true;
        }

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false; 
        }
        
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        char save = board[i][j];
        board[i][j] = '.';
        boolean result = false;

        result |= helper(board, word, index + 1, i, j + 1);

        if (!result) {
            result = helper(board, word, index + 1, i + 1, j);
        }

        if (!result) {
            result = helper(board, word, index + 1, i, j - 1);
        }

        if (!result) {
            result = helper(board, word, index + 1, i - 1, j);
        }

        board[i][j] = save;
        return result;
    }
}
