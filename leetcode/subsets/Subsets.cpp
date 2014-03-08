#include <iostream> 
#include <algorithm> 
#include <vector> 

using namespace std; 

class Solution {
public:
    vector<vector<int> > subsets(vector<int> &S) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        vector<vector<int> > result; 
        
        if (S.size() == 0) {
            vector<int> temp; 
            result.push_back(temp);
            return result; 
        }
        
        vector<int> nextS; 
        for (int i = 1; i < S.size(); i++) {
            nextS.push_back(S[i]); 
        }
        
        result = subsets(nextS); 
        int len = result.size(); 
        for (int i = 0; i < len; i++) {
            vector<int> temp = result[i]; 
            temp.push_back(S[0]);
            sort(temp.begin(), temp.end());
            result.push_back(temp); 
        }
        
        return result; 
    }
};

// Test driver 
int main() {
    Solution sln; 
    vector<int> input; 
    input.push_back(0); 
    //input.push_back(2);
    //input.push_back(3);
    
    vector<vector<int> > result = sln.subsets(input); 
    
    for (int i = 0; i < result.size(); i++) {
        for (int j = 0; j < result[i].size(); j++) {
            cout << result[i][j] << " "; 
        }
        
        cout << endl; 
    }
    return 0; 
}
