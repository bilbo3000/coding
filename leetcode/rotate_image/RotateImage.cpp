class Solution {
public:
    void rotate(vector<vector<int> > &matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n = matrix.size(); 
        if (n == 0) {
            return; 
        }
        
        for (int level = 0; level < n / 2; level++) {
            for (int i = level; i < n - 1 - level; i++) {
                int temp = matrix[level][i]; 
                matrix[level][i] = matrix[n - 1 - i][level]; 
                matrix[n - 1 - i][level] = matrix[n - 1 - level][n - 1 - i];
                matrix[n - 1 - level][n - 1 - i] = matrix[i][n - 1 - level]; 
                matrix[i][n - 1 - level] = temp; 
            }
        }
    }
};
