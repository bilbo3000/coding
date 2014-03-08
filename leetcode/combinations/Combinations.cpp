#include <iostream> 
#include <vector> 
#include <algorithm> 

using namespace std; 

class Solution {
public:
    vector<vector<int> > combine(int n, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        vector<vector<int> > result; 
        if (n < k) {
            return result; 
        }
        
        if (k == 1) {
            for (int i = n; i >= k; i--) {
                vector<int> vec; 
                vec.push_back(i); 
                result.push_back(vec); 
            }
            
            return result; 
        }
        
        for (int i = n; i >= k; i--) {
            vector<vector<int> > temp = combine(i - 1, k - 1);
            for (int j = 0; j < temp.size(); j++) {
                temp[j].insert(temp[j].begin(), i); 
                sort(temp[j].begin(), temp[j].end()); 
                result.push_back(temp[j]); 
            }
        }
        
        return result; 
    }
};

// test driver 
int main() {
    Solution sln; 
    vector<vector<int> > result = sln.combine(2, 2);
    
    for (int i = 0; i < result.size(); i++) {
        for (int j = 0; j < result[i].size(); j++) {
            cout << result[i][j] << " "; 
        }
        
        cout << endl; 
    }
     
    return 0; 
}
