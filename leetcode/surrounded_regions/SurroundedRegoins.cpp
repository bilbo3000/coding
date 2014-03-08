class Solution {
public:
    void helper(int x, int y, int m, int n, vector<vector<char> > &board, vector<vector<bool> > &flag) {
        flag[x][y] = true; 
        
        if (y + 1 < n && !flag[x][y + 1] && board[x][y + 1] == 'O') helper(x, y + 1, m, n, board, flag); 
        if (x + 1 < m && !flag[x + 1][y] && board[x + 1][y] == 'O') helper(x + 1, y, m, n, board, flag); 
        if (y - 1 >= 0 && !flag[x][y - 1] && board[x][y - 1] == 'O') helper(x, y - 1, m, n, board, flag); 
        if (x - 1 >= 0 && !flag[x - 1][y] && board[x - 1][y] == 'O') helper(x - 1, y, m, n, board, flag); 
    }
    
    void solve(vector<vector<char>> &board) {
        int m = board.size(); 
        if (m == 0) return; 
        int n = board[0].size(); 
        if (n == 0) return; 
        
        vector<vector<bool> > flag; 
        
        for (int i = 0; i < m; i++) {
            vector<bool> temp(n, false); 
            flag.push_back(temp); 
        }
        
        // Check borders
        for (int j = 0; j < n; j++) {
            if (!flag[0][j] && board[0][j] == 'O') {
                helper(0, j, m, n, board, flag); 
            }
            
            if (!flag[m - 1][j] && board[m - 1][j] == 'O') {
                helper(m - 1, j, m, n, board, flag); 
            }
        }
        
        for (int i = 0; i < m; i++) {
            if (!flag[i][0] && board[i][0] == 'O') {
                helper(i, 0, m, n, board, flag); 
            }
            
            if (!flag[i][n - 1] && board[i][n - 1] == 'O') {
                helper(i, n - 1, m, n, board, flag); 
            }
        }
        
        // Capture 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !flag[i][j]) {
                    board[i][j] = 'X'; 
                }
            }
        }
    }
};
