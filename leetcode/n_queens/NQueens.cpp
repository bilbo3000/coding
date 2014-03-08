#include <iostream> 
#include <vector> 
#include <cmath> 

using namespace std; 

class Solution {
public:
    bool check(vector<int> columnForRow, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {  // Check column
            if (columnForRow[i] == col) {
                return false; 
            }
            
            if (abs(row - i) == abs(col - columnForRow[i])) {
                return false; 
            }
        }
        
        return true; 
    }
    
    void NQueensHelper(int row, int n, vector<string> mat, vector<vector<string> > &result, vector<int> columnForRow) {
        if (row == n) {
            result.push_back(mat);
            return; 
        }
        
        for (int i = 0; i < n; i++) {
            if (check(columnForRow, row, i)) {
                columnForRow[row] = i; 
                mat[row][i] = 'Q'; 
                NQueensHelper(row + 1, n, mat, result, columnForRow); 
                mat[row][i] = '.'; 
            }
        }
            
    }
    
    vector<vector<string> > solveNQueens(int n) {
        vector<vector<string> > result;
        vector<string> mat; 
        string emptyStr = ""; 
        for (int i = 0; i < n; i++) {
            emptyStr = emptyStr + "."; 
        }
        
        for (int i = 0; i < n; i++) {
            mat.push_back(emptyStr); 
        }
        
        vector<int> columnForRow(n, -1); 
        
        NQueensHelper(0, n, mat, result, columnForRow); 
        
        return result; 
    }
};

int main() {
    Solution sln; 
    vector<vector<string> > result = sln.solveNQueens(4);
    
    for (int i = 0; i < result.size(); i++) {
        for (int j = 0; j < result[i].size(); j++) {
            cout << result[i][j] << endl; 
        }
        cout << endl; 
    } 
    
    return 0; 
}
