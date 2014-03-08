class Solution {
public:
    vector<vector<int> > permuteUnique(vector<int> &num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        vector<vector<int> > result; 
        if (num.size() == 0) {
            return result; 
        }
        
        if (num.size() == 1) {
            result.push_back(num); 
            return result; 
        }
        
        vector<int> next; 
        for (int i = 1; i < num.size(); i++) {
            next.push_back(num[i]); 
        }
        
        vector<vector<int> > tempResult = permuteUnique(next); 
        
        set<vector<int> > history; 
        for (int i = 0; i < tempResult.size(); i++) {
            for (int j = 0; j <= tempResult[i].size(); j++) {
                vector<int> temp(tempResult[i]);
                temp.insert(temp.begin() + j, num[0]);
                if (history.find(temp) == history.end()) {
                    result.push_back(temp);
                    history.insert(history.end(), temp); 
                }
            }
        }
        
        return result; 
    }
};
