class Solution {
public:
    vector<vector<int> > generate(int numRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        vector<vector<int> > result; 
        if (numRows == 0) {
            return result; 
        }
        
        vector<int> row; 
        row.push_back(1);
        result.push_back(row); 
        
        for (int i = 1; i < numRows; i++) {
            row.clear();
            row.push_back(1); 
            vector<int> currRow = result[i - 1]; 
            for (int j = 1; j < currRow.size(); j++) {
                int sum = currRow[j - 1] + currRow[j]; 
                row.push_back(sum); 
            }
            row.push_back(1); 
            result.push_back(row); 
        }
        
        return result; 
    }
};
