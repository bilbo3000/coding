public class Solution {

    public void solve(char[][] board) {
        int m = board.length;

        if (m == 0) {
            return;
        }

        int n = board[0].length;

        if (n == 0) {
            return;
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                helper(board, i, 0);
            }

            if (board[i][n - 1] == 'O') {
                helper(board, i, n - 1);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                helper(board, 0, j);
            }

            if (board[m - 1][j] == 'O') {
                helper(board, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void helper(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(i);
        q.add(j);
        board[i][j] = '.';

        while (q.size() != 0) {
            int x = q.remove();
            int y = q.remove();

            if (y < n - 1 && board[x][y + 1] == 'O') {
                q.add(x);
                q.add(y + 1);
                board[x][y + 1] = '.';
            }

            if (x < m - 1 && board[x + 1][y] == 'O') {
                q.add(x + 1);
                q.add(y);
                board[x + 1][y] = '.';
            }

            if (y > 0 && board[x][y - 1] == 'O') {
                q.add(x);
                q.add(y - 1);
                board[x][y - 1] = '.';
            }

            if (x > 0 && board[x - 1][y] == 'O') {
                q.add(x - 1);
                q.add(y);
                board[x - 1][y] = '.';
            }
        }
    }
}
