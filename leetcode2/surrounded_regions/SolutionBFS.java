public class SolutionBFS {
    int m = 0;
    int n = 0;
    char[][] board;

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        m = board.length;
        n = board[0].length;
        this.board = board;

        for (int i = 0; i < n; i++) {
            // Top row
            bfsMark(i, 0);

            // Bottom row
            bfsMark(i, m - 1);
        }

        for (int i = 0; i < m; i++) {
            // Left column
            bfsMark(0, i);

            // Right column
            bfsMark(n - 1, i);
        }

        // Mark
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '+') {
                    board[i][j] = 'O';
                }
                else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfsMark(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[y][x] != 'O') return;

        Queue<Integer> xPosition = new LinkedList<Integer>();
        Queue<Integer> yPosition = new LinkedList<Integer>();

        board[y][x] = '+';
        xPosition.offer(x);
        yPosition.offer(y);

        while (xPosition.size() != 0) {
            x = xPosition.poll();
            y = yPosition.poll();

            // Right
            if (x + 1 < n && board[y][x + 1] == 'O'){
                board[y][x + 1] = '+';
                xPosition.offer(x + 1);
                yPosition.offer(y);
            }

            // Down
            if (y + 1 < m && board[y + 1][x] == 'O') {
                board[y + 1][x] = '+';
                xPosition.offer(x);
                yPosition.offer(y + 1);
            }

            // Left
            if (x - 1 >= 0 && board[y][x - 1] == 'O') {
                board[y][x - 1] = '+';
                xPosition.offer(x - 1);
                yPosition.offer(y);
            }

            // Top
            if (y - 1 >= 0 && board[y - 1][x] == 'O') {
                board[y - 1][x] = '+';
                xPosition.offer(x);
                yPosition.offer(y - 1);
            }
        }
    }
}
