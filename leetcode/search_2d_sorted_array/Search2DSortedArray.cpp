class Solution {
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int m = matrix.size(); 
        int n = matrix[0].size(); 
        
        if (m == 0 || n == 0) {
            return false; 
        }
        
        int i = 0; 
        int j = n - 1; 
        
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true; 
            }
            
            if (matrix[i][j] > target) {
                j--; 
            }
            else {
                i++; 
            }
        }
        
        return false; 
    }
};
