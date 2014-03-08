#include <iostream> 
#include <vector> 

using namespace std; 

class Solution {
public:
    vector<vector<int> > permute(vector<int> &num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        vector<vector<int> > result; 
        if (num.size() <= 1) {
            result.push_back(num);
            return result; 
        }
        
        vector<int> newNum; 
        for (int i = 1; i < num.size(); i++) {
            newNum.push_back(num[i]); 
        }
        
        vector<vector<int> > returnVal = permute(newNum); 
        
        for (int i = 0; i < returnVal.size(); i++) {
            for (int j = 0; j <= returnVal[i].size(); j++) {
                vector<int> temp = returnVal[i]; 
                temp.insert(temp.begin() + j, num[0]); 
                result.push_back(temp); 
            }
        }
        
        return result; 
    }
};

int main() {
    Solution sln; 
    vector<int> num; 
    num.push_back(1); 
    num.push_back(2); 
    num.push_back(3);
    
    vector<vector<int> > result = sln.permute(num);
    
    for (int i = 0; i < result.size(); i++) {
        for (int j = 0; j < result[i].size(); j++) {
            cout << result[i][j] << " "; 
        }
        cout << endl; 
    } 
    
    return 0; 
}
