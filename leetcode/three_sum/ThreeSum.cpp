#include <iostream> 
#include <vector> 
#include <algorithm> 

using namespace std; 

class Solution {
public:
    vector<vector<int> > threeSum(vector<int> &num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        vector<vector<int> > result; 
        if (num.size() < 3) {
            return result; 
        }
        
        // Sort input
        sort(num.begin(), num.end()); 
        
        int len = num.size(); 
        int i = 0; 
        while(i < len) {
            int j = len - 1; 
            int k = i + 1; 
            while (k < j) {
                if ((num[i] + num[k] + num[j] < 0)) {
                    k++; 
                }
                else if (num[i] + num[k] + num[j] > 0) {
                    j--; 
                }
                else {
                    vector<int> temp; 
                    temp.push_back(num[i]);
                    temp.push_back(num[k]); 
                    temp.push_back(num[j]);
                    result.push_back(temp); 
                    k++; 
                    while (k < len && num[k] == num[k - 1]) {
                        k++; 
                    } 
                    
                    j--; 
                    while (j >= 0 && num[j] == num[j + 1]) {
                        j--; 
                    } 
                }
            }
            
            i++; 
            while (i < len && num[i] == num[i - 1]) {
                i++; 
            } 
        } 
        
        return result; 
    }
};

// Test driver 
int main() {
    Solution sln; 
    vector<int> input; 
  
    input.push_back(-1);
    input.push_back(0);
    input.push_back(1);   
    input.push_back(2); 
    input.push_back(-1); 
    input.push_back(-4); 
  
    vector<vector<int> > result = sln.threeSum(input); 
    
    for (int i = 0; i < result.size(); i++) {
        for (int j = 0; j < result[i].size(); j++) {
            cout << result[i][j] << " "; 
        }
        
        cout << endl; 
    }
    return 0; 
}
