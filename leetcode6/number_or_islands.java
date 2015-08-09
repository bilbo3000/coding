/**
 * Find the number of islands in a given matrix. 
 * The idea was to loop through the matrix and for each 1, increment the count and 
 * run a BSF starting from that element to reset '1'. Note that need to set zeros 
 * before put in the queue to avoid going into circles. 
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
    
    public int numIslands(char[][] grid) {
        int m = grid.length; 
        
        if (m == 0) {
            return 0; 
        }
        
        int n = grid[0].length; 
        
        if (n == 0) {
            return 0; 
        }
        
        int result = 0; 
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    result++; 
                    helper(grid, i, j);
                }
            }
        }
        
        return result; 
    }
    
    private void helper(char[][] grid, int row, int col) {
        grid[row][col] = '0'; 
        int m = grid.length; 
        int n = grid[0].length; 
        Queue<Point> q = new LinkedList<>(); 
        q.add(new Point(row, col));
        
        while (q.size() != 0) {
            Point curr = q.remove(); 
            int x = curr.x; 
            int y = curr.y; 

            if (x > 0 && grid[x - 1][y] == '1') {
                grid[x - 1][y] = '0';
                q.add(new Point(x - 1, y));
            }
            
            if (y < n - 1 && grid[x][y + 1] == '1') {
                grid[x][y + 1] = '0'; 
                q.add(new Point(x, y + 1));
            }
            
            if (x < m - 1 && grid[x + 1][y] == '1') {
                grid[x + 1][y] = '0'; 
                q.add(new Point(x + 1, y));
            }
            
            if (y > 0 && grid[x][y - 1] == '1') {
                grid[x][y - 1] = '0';
                q.add(new Point(x, y - 1));
            }
        }
    }
}
