#include <iostream> 
#include <vector> 

using namespace std; 

class Solution {
public:
    void setZeroes(vector<vector<int> > &matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if (matrix.size() == 0) {
            return; 
        }
        
        if (matrix[0].size() == 0) {
            return; 
        }
        
        int rowSize = matrix.size(); 
        int colSize = matrix[0].size(); 
        
        bool rowHistory[rowSize]; 
        for (int i = 0; i < rowSize; i++) {
            rowHistory[i] = false; 
        }
        
        bool colHistory[colSize]; 
        for (int i = 0; i < colSize; i++) {
            colHistory[i] = false; 
        }
        
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (matrix[i][j] == 0) {
                    rowHistory[i] = true; 
                    colHistory[j] = true; 
                }
            }
        }

        
        for (int i = 0; i < rowSize; i++) {
            if (rowHistory[i]) {
                for (int j = 0; j < colSize; j++) {
                    matrix[i][j] = 0; 
                }
            }
        }
        
        
        
        for (int i = 0; i < colSize; i++) {
            if (colHistory[i]) {
                for (int j = 0; j < rowSize; j++) {
                    matrix[j][i] = 0; 
                }
            }
        }
        
    }
};

int main() {
    Solution sln; 
    vector<vector<int> > matrix; 
    // [[0,0,0,5],[4,3,1,4],[0,1,1,4],[1,2,1,3],[0,0,1,1]]
    vector<int> row; 
    row.push_back(0);
    row.push_back(0); 
    row.push_back(0); 
    row.push_back(5); 
    matrix.push_back(row); 
     
    row.clear(); 
    row.push_back(4);
    row.push_back(3); 
    row.push_back(1); 
    row.push_back(4); 
    matrix.push_back(row);
     
    row.clear(); 
    row.push_back(0);
    row.push_back(1); 
    row.push_back(1); 
    row.push_back(4); 
    matrix.push_back(row);
    
    row.clear();    
    row.push_back(1);
    row.push_back(2); 
    row.push_back(1); 
    row.push_back(3); 
    matrix.push_back(row);
    
    row.clear(); 
    row.push_back(0);
    row.push_back(0); 
    row.push_back(1); 
    row.push_back(1); 
    matrix.push_back(row);
    
    row.clear(); 
    
    sln.setZeroes(matrix); 
    
    for (int i = 0; i < matrix.size(); i++) {
        for (int j = 0; j < matrix[0].size(); j++) {
            cout << matrix[i][j] << " "; 
        }
        
        cout << endl; 
    }
    return 0; 
}
