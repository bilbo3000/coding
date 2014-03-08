#include <iostream> 
#include <vector> 
#include <cmath> 

using namespace std; 

class Solution {
public:
    int totalNQueens(int n) {
        int * rowcol = new int[n]; 
        int cnt = 0; 
        helper(0, rowcol, n, cnt); 
        
        return cnt; 
    }
    
    void helper(int currRow, int rowcol[], int n, int &cnt) {
        // int n = rowcol.size(); 
        
        if (currRow == n) {
            cnt++; 
            return; 
        }
        
        if (currRow < n) {
            for (int i = 0; i < n; i++) {
                if (check(currRow, i, rowcol)) {
                    rowcol[currRow] = i; 
                    helper(currRow + 1, rowcol, n, cnt); 
                }
            }
        }
    }
    
    bool check(int row, int col, int rowcol[]) {
        if (row == 0) {
            return true; 
        }
        
        for (int i = row - 1; i >=0; i--) {
            if (rowcol[i] == col) {
                return false; 
            }
            
            if (abs(i - row) == abs(rowcol[i] - col)) {
                return false; 
            }
        }
        
        return true; 
    }
};

int main() {
	Solution sln; 
	cout << sln.totalNQueens(8) << endl; 
}
