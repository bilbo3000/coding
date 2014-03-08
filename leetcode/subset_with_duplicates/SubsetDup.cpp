#include <iostream> 
#include <set> 
#include <vector> 
#include <algorithm> 

using namespace std; 

class Solution {
public:
    vector<vector<int> > subsetsWithDup(vector<int> &S) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        set<vector<int> > history; 
        return helper(S, history); 
    }
    
    vector<vector<int> > helper(vector<int> v, set<vector<int> > &history) {
        vector<vector<int> > result; 
        if (v.size() == 0) {
            vector<int> empty; 
            result.push_back(empty);
            return result; 
        }
        
        vector<int> temp; 
        for (int i = 1; i < v.size(); i++) {
            temp.push_back(v[i]); 
        }
        
        result = helper(temp, history);
        int size = result.size(); 
        
        for (int i = 0; i < size; i++) {
            vector<int> newVec = result[i]; 
            newVec.push_back(v[0]);
            sort(newVec.begin(), newVec.end()); 
            
            if (history.find(newVec) == history.end()) {
                result.push_back(newVec);
                history.insert(history.end(), newVec); 
            }
        }
        
        return result; 
    }
};


int main() {
	Solution sln; 
	vector<int> input; 
	input.push_back(1);
	input.push_back(1); 
	 
	vector<vector<int> > result = sln.subsetsWithDup(input); 
	
	for (int i = 0; i < result.size(); i++) {
		for (int j = 0; j < result[i].size(); j++) {
			cout << result[i][j] << " "; 
		}
		cout << endl; 
	}
	return 0; 
}
