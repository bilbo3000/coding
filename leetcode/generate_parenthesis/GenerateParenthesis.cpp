#include <iostream> 
#include <vector> 
#include <string> 

using namespace std; 

class Solution {
private: 
    vector<string> result; 
public:
    void generateParenthesisHelper(string str, int leftCnt, int rightCnt, int n) {
        if (leftCnt == n && rightCnt == n) {
            result.push_back(str);
            return; 
        }
        
        if (leftCnt < n) {
            generateParenthesisHelper(str + "(", leftCnt + 1, rightCnt, n); 
        }
        
        if (rightCnt < n && rightCnt < leftCnt) {
            generateParenthesisHelper(str + ")", leftCnt, rightCnt + 1, n); 
        }
    }
    vector<string> generateParenthesis(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        result.clear(); 
        
        generateParenthesisHelper("", 0, 0, n);
        
        return result; 
    }
};

int main() {
    Solution sln; 
    vector<string> output = sln.generateParenthesis(3);
    
    int i = 0; 
    while(i < output.size()) {
        cout << output[i] << endl; 
        i++; 
    } 
    return 0; 
}
