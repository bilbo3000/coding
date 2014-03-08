public class Solution {
    private int m = 0;
    private int n = 0;

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return false;

        m = board.length;

        if(m == 0) return false;

        n = board[0].length;

        if (n == 0) return false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, i, j, word, 0)) return true;
                }
            }
        }


        return false;
    }

    private boolean helper(char[][] board, int i, int j, String word, int index) {
        if (index == word.length() - 1) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '+';
        boolean result = false;

        if (j < n - 1 && word.charAt(index + 1) == board[i][j + 1]) {
            result = helper(board, i, j + 1, word, index + 1);
        }

        if (!result && i < m - 1 && word.charAt(index + 1) == board[i + 1][j]) {
            result = helper(board, i + 1, j, word, index + 1);
        }

        if (!result && j > 0 && word.charAt(index + 1) == board[i][j - 1]) {
            result = helper(board, i, j - 1, word, index + 1);
        }

        if (!result && i > 0 && word.charAt(index + 1) == board[i - 1][j]) {
            result = helper(board, i - 1, j, word, index + 1);
        }

        board[i][j] = temp;
        return result;
    }
}
