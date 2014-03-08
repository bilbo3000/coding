#include <iostream> 
#include <vector> 
#include <cmath> 

using namespace std; 

class Solution {
private: 
    vector<vector<int> > result;
    vector<vector<bool> > mat; 
    
public:
    void right(int cnt, int n, int x, int y) {
        result[x][y] = cnt;
        mat[x][y] = true; 
        
        if (cnt == pow(n, 2)) {
            return; 
        }
        
        if ((y + 1) < n && !mat[x][y + 1]) {
            return right(cnt + 1, n, x, y + 1); 
        }
        else if ((x + 1) < n && !mat[x + 1][y]) {
            return down(cnt + 1, n, x + 1, y); 
        }
        
        return; 
    }
    
    void down(int cnt, int n, int x, int y) {
        result[x][y] = cnt;
        mat[x][y] = true; 
        
        if (cnt == pow(n, 2)) {
            return; 
        }
        
        if ((x + 1) < n && !mat[x + 1][y]) {
            return down(cnt + 1, n, x + 1, y); 
        }
        else if((y - 1) >= 0 && !mat[x][y - 1]) {
            return left(cnt + 1, n, x, y - 1); 
        }
        
        return; 
    }
    
    void left(int cnt, int n, int x, int y) {
        result[x][y] = cnt;
        mat[x][y] = true; 
        
        if (cnt == pow(n, 2)) {
            return; 
        }
        
        if ((y - 1) >= 0 && !mat[x][y - 1]) {
            return left(cnt + 1, n, x, y - 1); 
        }
        else if ((x - 1) >= 0 && !mat[x - 1][y]) {
            return up(cnt + 1, n, x - 1, y); 
        }
        
        return; 
    }
    
    void up(int cnt, int n, int x, int y) {
        result[x][y] = cnt;
        mat[x][y] = true; 
        
        if (cnt == pow(n, 2)) {
            return; 
        }
        
        if ((x - 1) >= 0 && !mat[x - 1][y]) {
            return up(cnt + 1, n, x - 1, y); 
        }
        else if ((y + 1) < n && !mat[x][y + 1]) {
            return right(cnt + 1, n, x, y + 1); 
        }
        
        return; 
    }
    
    vector<vector<int> > generateMatrix(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        result.clear(); 
        
        if (n <= 0) {
            return result; 
        }
        
        result.resize(n);
        mat.resize(n); 
        
        for(int i = 0; i < n; i++) {
            result[i].assign(n, 0); 
            mat[i].assign(n, false); 
        }
        
        right(1, n, 0, 0); 
        
        return result; 
    }
};

int main() {
    Solution sln; 
    vector<vector<int> > result = sln.generateMatrix(3);
    
    for (int i = 0; i < result.size(); i++) {
        for (int j = 0; j < result[i].size(); j++) {
            cout << result[i][j] << " "; 
        }
        cout << endl; 
    } 
    return 0; 
}
