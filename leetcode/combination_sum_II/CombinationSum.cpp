#include <iostream> 
#include <set> 
#include <vector> 
#include <algorithm> 

using namespace std; 

class Solution {
public:
    vector<vector<int> > combinationSum2(vector<int> &num, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        vector<vector<int> > result; 
        vector<int> collection; 
        set<vector<int> > history; 
        helper(num, collection, target, result, history); 
        
        return result; 
    }
    
    void helper(vector<int> num, vector<int> collection, int target, vector<vector<int> > &result, set<vector<int> > &history) {
        if (num.size() == 0) {
            return; 
        }
        
        for (int i = 0; i < num.size(); i++) {
            vector<int> nextCollection(collection);  
            nextCollection.push_back(num[i]);
            
            if (num[i] == target) {
                sort(nextCollection.begin(), nextCollection.end()); 
                if (history.find(nextCollection) == history.end()) {
                    result.push_back(nextCollection); 
                    history.insert(history.end(), nextCollection); 
                } 
            }
            
            vector<int> nextNum(num.begin() + i + 1, num.end()); 

            if (target - num[i] > 0) {
                helper(nextNum, nextCollection, target - num[i], result, history); 
            }
        }
    }
};

int main() {
// [10,1,2,7,6,1,5], 8
	Solution sln; 
	vector<int> num; 
	num.push_back(10); 
	num.push_back(1);
	num.push_back(2);
	num.push_back(7);
	num.push_back(6);
	num.push_back(1);
	num.push_back(5);
	
	vector<vector<int> > result = sln.combinationSum2(num, 8);
	for (int i = 0; i < result.size(); i++) {
		for (int j = 0; j < result[i].size(); j++) {
			cout << result[i][j] << " "; 
		}
		
		cout << endl; 
	}  
	return 0; 
}
