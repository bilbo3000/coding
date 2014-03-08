#include <iostream> 
#include <vector> 
#include <algorithm> 
#include <set> 

using namespace std; 

class Solution {
public:    
    vector<vector<int> > fourSum(vector<int> &num, int target) {
        vector<vector<int> > result; 
        set<vector<int> > history;
        
        if (num.size() == 0 || num.size() < 4) {
            return result; 
        }
        
        sort(num.begin(), num.end()); 
        
        for (int i = 0; i < num.size() - 3; i++) {
            vector<int> quad;
            vector<int> newNum(num.begin() + i + 1, num.end()); 
            quad.push_back(num[i]); 
            threeSum(newNum, quad, target - num[i], result, history); 
        } 
        
        return result; 
    }

	void threeSum(vector<int> num, vector<int> quad, int target, vector<vector<int> > &result, set<vector<int> > &history) {
        if (num.size() < 3) {
            return; 
        }
        
        for (int i = 0; i < num.size() - 2; i++) {
            int j = num.size() - 1; 
            int k = i + 1; 
            
            while (k < j) {
                int sum = num[i] + num[k] + num[j]; 
                if (sum == target) {
                    vector<int> newQuad(quad); 
                    newQuad.push_back(num[i]);
                    newQuad.push_back(num[k]); 
                    newQuad.push_back(num[j]); 
                    
                    if (history.find(newQuad) == history.end()) {
                        result.push_back(newQuad); 
                        history.insert(history.end(), newQuad); 
                    }
                    
                    k++; 
                    j--; 
                }
                else if (sum > target) {
                    j--; 
                }
                else {
                    k++; 
                }
            }
        } 
    }    
};

int main() {
	Solution sln; 
	// S = {1 0 -1 0 -2 2}, and target = 0
	vector<int> num; 
	num.push_back(1); 
	num.push_back(0);
	num.push_back(-1);
	num.push_back(0);
	num.push_back(-2);
	num.push_back(2);
	vector<vector<int> > result = sln.fourSum(num, 0); 
	
	for (int i = 0; i < result.size(); i++) {
		for (int j = 0; j < result[i].size(); j++) {
			cout << result[i][j] << " "; 
		}	
		
		cout << endl; 
	}
	return 0; 
}
