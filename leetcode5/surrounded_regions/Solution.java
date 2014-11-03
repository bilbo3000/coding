import java.util.*;

public class Solution {
    private int m = 0;
    private int n = 0;

    public void solve(char[][] board) {
        m = board.length;

        if (m == 0) {
            return;
        }

        n = board[0].length;

        if (n == 0) {
            return;
        }

        // BFS implementation 
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }

            if (board[m - 1][j] == 'O') {
                bfs(board, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }

            if (board[i][n - 1] == 'O') {
                bfs(board, i, n - 1);
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

    private void bfs(char[][] board, int i, int j) {
        List<List<Map.Entry<Integer, Integer>>> levels = new ArrayList<List<Map.Entry<Integer, Integer>>>();
        levels.add(new ArrayList<Map.Entry<Integer, Integer>>());
        levels.add(new ArrayList<Map.Entry<Integer, Integer>>());
        int lev0 = 0;
        int lev1 = 1;
        levels.get(lev0).add(new AbstractMap.SimpleEntry<Integer, Integer>(i, j));
        board[i][j] = '.';

        while (levels.get(lev0).size() != 0) {
            List<Map.Entry<Integer, Integer>> curr = levels.get(lev0);
            List<Map.Entry<Integer, Integer>> next = levels.get(lev1);

            for (Map.Entry<Integer, Integer> item : curr) {
                int a = item.getKey();
                int b = item.getValue();

                if (b < n - 1 && board[a][b + 1] == 'O') {
                    board[a][b + 1] = '.';
                    next.add(new AbstractMap.SimpleEntry<Integer, Integer>(a, b + 1));
                }

                if (a < m - 1 && board[a + 1][b] == 'O') {
                    board[a + 1][b] = '.';
                    next.add(new AbstractMap.SimpleEntry<Integer, Integer>(a + 1, b));
                }

                if (b > 0 && board[a][b - 1] == 'O') {
                    board[a][b - 1] = '.';
                    next.add(new AbstractMap.SimpleEntry<Integer, Integer>(a, b - 1));
                }

                if (a > 0 && board[a - 1][b] == 'O') {
                    board[a - 1][b] = '.';
                    next.add(new AbstractMap.SimpleEntry<Integer, Integer>(a - 1, b));
                }
            }

            curr.clear();
            lev0 = lev0 ^ lev1;
            lev1 = lev0 ^ lev1;
            lev0 = lev0 ^ lev1;
        }
    }
}
