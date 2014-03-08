#include <iostream> 
#include <set> 
#include <vector> 
#include <algorithm> 

using namespace std; 

class Solution {
public:
    void combinationSumHelper(vector<int> candidates, int target, vector<int> output, vector<vector<int> > &result, set<vector<int> > & history, int index) {
        if (target == 0) {
            if (history.find(output) == history.end()) {
                result.push_back(output); 
                history.insert(output); 
            }
            return; 
        }
        
        for (int i = index; i < candidates.size(); i++) {
            if (candidates[i] <= target) {
                output.push_back(candidates[i]);
                combinationSumHelper(candidates, target - candidates[i], output, result, history, i); 
                output.pop_back(); 
            }
        }
    }
    
    vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        vector<vector<int> > result; 
        set<vector<int> > history; 
        
        if (candidates.size() == 0) {
            return result; 
        }
        
        sort(candidates.begin(), candidates.end()); 
        vector<int> output; 
        combinationSumHelper(candidates, target, output, result, history, 0);
        
        return result; 
    }
};

// Test driver 
int main() {
    Solution sln; 
    vector<int> candidates; 
    candidates.push_back(2); 
    candidates.push_back(3); 
    candidates.push_back(6); 
    candidates.push_back(7); 
    
    vector<vector<int> > result; 
    result = sln.combinationSum(candidates, 7);  
    
    for (int i = 0; i < result.size(); i++) {
        for (int j = 0; j < result[i].size(); j++) {
            cout << result[i][j] << " "; 
        }
        
        cout << endl; 
    }
    return 0; 
}
