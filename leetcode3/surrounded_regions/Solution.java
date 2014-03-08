public class Solution {
    class Point {
        int x; 
        int y;
        
        Point(int x, int y) {
            this.x = x; 
            this.y = y; 
        }
    }
    
    private char[][] board; 
    
    public void solve(char[][] b) {
        this.board = b; 
        int m = board.length; 
        
        if (m == 0) return; 
        
        int n = board[0].length; 
        
        if (n == 0) return; 
        
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                helper(0, j); 
            }
            
            if (board[m - 1][j] == 'O') {
                helper(m - 1, j); 
            }
        }
        
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                helper(i, 0); 
            }
            
            if (board[i][n - 1] == 'O') {
                helper(i, n - 1); 
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '+') {
                    board[i][j] = 'O'; 
                }
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X'; 
                }
            }
        }
    }
    
    private void helper(int i, int j) {
        Queue<Point> q = new LinkedList<Point>(); 
        board[i][j] = '+';
        q.add(new Point(i, j)); 
        int m = board.length; 
        int n = board[0].length;
        
        while (q.size() != 0) {
            Point curr = q.poll();
            int x = curr.x; 
            int y = curr.y; 
            
            if (y < n - 1 && board[x][y + 1] == 'O') {
                board[x][y + 1] = '+'; 
                q.offer(new Point(x, y + 1));  
            }
            
            if (x < m - 1 && board[x + 1][y] == 'O') {
                board[x + 1][y] = '+'; 
                q.offer(new Point(x + 1, y));  
            }
            
            if (y > 0 && board[x][y - 1] == 'O') {
                board[x][y - 1] = '+'; 
                q.offer(new Point(x, y - 1)); 
            }
            
            if (x > 0 && board[x - 1][y] == 'O') {
                board[x - 1][y] = '+'; 
                q.offer(new Point(x - 1, y));  
            }
        }
    }
}
