#include <iostream> 
#include <vector> 
#include <cmath> 

using namespace std; 

class Solution {
public:
    void totalNQueensHelper(int n, int row, vector<int> colForRow, int &cnt) {
        if (row == n) {
            cnt++; 
            return; 
        }
        
        for (int i = 0; i < n; i++) {  // Try all columns of current row
            bool check = false; 
            
            for (int j = row; j >= 0; j--) {  // Check previous rows if there is any conflicts
                if (colForRow[j] == i || abs(i - colForRow[j]) == abs(row - j)) {
                    check = true; 
                }
            }
            
            if (!check) {
                colForRow[row] = i; 
                totalNQueensHelper(n, row + 1, colForRow, cnt); 
                colForRow[row] = -1; 
            }
        }
    }
    
    int totalNQueens(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int cnt = 0; 
        vector<int> colForRow(n, -1); 
        totalNQueensHelper(n, 0, colForRow, cnt);
        return cnt; 
    }
};

int main() {
    Solution sln; 
    cout << sln.totalNQueens(11) << endl; 
    return 0; 
}
