/**
 * Capture all 'O' that are surrounded by 'X'. 
 * The idea was to go through all for edges and run a BFS starting 
 * from each 'O' to convert adjacent 'O' to '.'. Then revert '.' back 
 * to 'O' and 'O' to 'X'. 
 */ 
public class Solution {
    class Point {
        int x; 
        int y; 
        Point(int x, int y) {
            this.x = x; 
            this.y = y; 
        }
    }
    
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
    
    public void helper(char[][] board, int row, int col) {
        board[row][col] = '.'; 
        int m = board.length; 
        int n = board[0].length; 
        Queue<Point> q = new LinkedList<>(); 
        q.add(new Point(row, col));
        
        while (q.size() != 0) {
            Point curr = q.remove(); 
            int x = curr.x; 
            int y = curr.y; 
            
            if (x > 0 && board[x - 1][y] == 'O') {
                board[x - 1][y] = '.'; 
                q.add(new Point(x - 1, y)); 
            }
            
            if (y < n - 1 && board[x][y + 1] == 'O') {
                board[x][y + 1] = '.'; 
                q.add(new Point(x, y + 1)); 
            }
            
            if (x < m - 1 && board[x + 1][y] == 'O') {
                board[x + 1][y] = '.'; 
                q.add(new Point(x + 1, y)); 
            }
            
            if (y > 0 && board[x][y - 1] == 'O') {
                board[x][y - 1] = '.'; 
                q.add(new Point(x, y - 1)); 
            }
        }
    }
}
