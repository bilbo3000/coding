class Solution {
public:
    int minimumTotal(vector<vector<int> > &triangle) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int level = triangle.size(); 
        if (level == 1) {
            return triangle[0][0]; 
        }
        
        for (int i = level - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].size(); j++) {
                triangle[i][j] = min(triangle[i + 1][j], triangle[i + 1][j + 1]) + triangle[i][j]; 
            }
        }
        
        return triangle[0][0]; 
    }
};
