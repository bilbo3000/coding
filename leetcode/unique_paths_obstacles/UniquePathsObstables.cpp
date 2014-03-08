#include <iostream> 
#include <vector> 

using namespace std; 

class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int> > &obstacleGrid) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int m = obstacleGrid.size(); 
        int n = obstacleGrid[0].size(); 
        
        int T[m][n]; 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                T[i][j] = 0; 
            }
        }
        
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break; 
            }
            
            T[i][0] = 1; 
        }
        
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break; 
            }
            
            T[0][i] = 1; 
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    if (obstacleGrid[i][j - 1] != 1) {
                        T[i][j] += T[i][j - 1]; 
                    }
                    
                    if (obstacleGrid[i - 1][j] != 1) {
                        T[i][j] += T[i - 1][j]; 
                    }
                }
            }
        }
        
        return T[m - 1][n - 1]; 
    }
};

int main() {
    Solution sln; 
    vector<vector<int> > grid; 
    for (int i = 0; i < 3; i++) {
        vector<int> temp(3, 0);
        grid.push_back(temp);  
    }
    
    grid[1][1] = 1;
    
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            cout << grid[i][j] << " "; 
        }
        cout << endl; 
    }
    
    cout << sln.uniquePathsWithObstacles(grid) << endl; 
    return 0; 
}
