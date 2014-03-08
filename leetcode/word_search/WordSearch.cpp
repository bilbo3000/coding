#include <iostream> 
#include <vector> 
#include <string>

using namespace std; 

class Solution {
public:
    int m; 
    int n; 
    
    bool find(vector<vector<char> > &board, string str, int x, int y, vector<vector<bool> > mat) {
        
        mat[x][y] = true; 
        
        if (str.length() == 0) {
            return true; 
        }
         
        if (str.length() == 1) {
        
            if ((y + 1) < n && !mat[x][y + 1] && board[x][y + 1] == str[0]) {
                return true; 
            }
            
            if ((x + 1) < m && !mat[x + 1][y] && board[x + 1][y] == str[0]) {
                return true; 
            }
            
            if ((y - 1) >= 0 && !mat[x][y - 1] && board[x][y - 1] == str[0]) {
                return true; 
            }
            
            if ((x - 1) >= 0 && !mat[x - 1][y] && board[x - 1][y] == str[0]) {
                return true; 
            }
            
            return false; 
        }
        else {
            bool isSuccess = false; 
            
            if (!isSuccess && (y + 1) < n && !mat[x][y + 1] && board[x][y + 1] == str[0]) {
                isSuccess = find(board, str.substr(1), x, y + 1, mat); 
            }
            
            if (!isSuccess && (x + 1) < m && !mat[x + 1][y] && board[x + 1][y] == str[0]) {
                isSuccess = find(board, str.substr(1), x + 1, y, mat);  
            }
            
            if (!isSuccess && (y - 1) >= 0 && !mat[x][y - 1] && board[x][y - 1] == str[0]) {
                isSuccess = find(board, str.substr(1), x, y - 1, mat);  
            }
            
            if (!isSuccess && (x - 1) >= 0 && !mat[x - 1][y] && board[x - 1][y] == str[0]) {
                isSuccess = find(board, str.substr(1), x - 1, y, mat); 
            }
            
            return isSuccess; 
        }
    }
    
    bool exist(vector<vector<char> > &board, string word) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (board.size() == 0 || word == "") {
            return false; 
        }
        
        m = board.size(); 
        if (board[0].size() == 0) {
            return false; 
        }
        n = board[0].size();
        
        vector<vector<bool> > mat;  // Matrix to track if a cell has been visited 
        mat.resize(m); 
        for (int i = 0; i < m; i++) {
            mat[i].assign(n, false); 
        }
        
        bool doesExist = false; 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!doesExist && board[i][j] == word[0]) { 
                    doesExist = find(board, word.substr(1), i, j, mat); 
                }
            }
        }
        
        return doesExist; 
    }
};

int main() {
    vector<vector<char> > board; 
    /*
    vector<char> row1; 
    row1.push_back('A');
    row1.push_back('B');
    row1.push_back('C');
    row1.push_back('E');
    board.push_back(row1);
    
    vector<char> row2; 
    row2.push_back('S');
    row2.push_back('F');
    row2.push_back('C');
    row2.push_back('S');
    board.push_back(row2);  
    
    vector<char> row3; 
    row3.push_back('A');
    row3.push_back('D');
    row3.push_back('E');
    row3.push_back('E');
    board.push_back(row3); 
    */
    
    /*
    vector<char> row; 
    row.assign(4, 'a'); 
    board.push_back(row); 
    board.push_back(row); 
    board.push_back(row); 
    board.push_back(row); 
    
    vector<char> row5; 
    row5.assign(4, 'a');
    // row5.push_back('b');
    board.push_back(row5);
    */
    
    vector<char> row; 
    row.push_back('a');
    board.push_back(row);
      
    Solution sln; 
    // aaaaaaaaaaaaaaaaaaaa
    if (sln.exist(board, "a")) {
        cout << 1 << endl; 
    }
    else {
        cout << 0 << endl; 
    }
    
    return 0; 
}
