class Solution {
public:
    vector<int> spiralOrder(vector<vector<int> > &matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        vector<int> result; 
        int row = matrix.size(); 
        if (row == 0) {
            return result; 
        }
        
        int col = matrix[0].size(); 
        
        if (col == 0) {
            return result; 
        }
        
        for (int level = 0; level <= (min(row, col) - 1) / 2; level++) {
            if (level == row / 2) {
                for (int i = level; i < col - level; i++) {
                    result.push_back(matrix[level][i]);
                }
            }
            else if (level == col / 2) {
                for (int j = level; j < row - level; j++) {
                    result.push_back(matrix[j][level]); 
                }
            }
            else {
                // Moving left 
                for (int a = level; a < col - 1 - level; a++) {
                    result.push_back(matrix[level][a]); 
                }
     
                // Moving down
                for (int b = level; b < row - 1 - level; b++) {
                    result.push_back(matrix[b][col - 1 - level]); 
                }
                
                // Moving left 
                for (int c = col - 1 - level; c > level; c--) {
                    result.push_back(matrix[row - 1 - level][c]);
                }
                
                // Moving up
                for (int d = row - 1 - level; d > level; d--) {
                    result.push_back(matrix[d][level]); 
                }
            }
        }
        
        return result; 
    }
};
