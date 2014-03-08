#include <iostream> 
#include <vector> 

using namespace std; 

class Solution {
private: 
    vector<string> result;
public: 
    void printCombinations(string digits, string str, string mapping[]) {
        int digit = digits[0] - '0';  
        string s = mapping[digit - 2]; 
        if (digits.length() == 1) { 
            for(int i = 0; i < s.length(); i++) {
               result.push_back(str + s[i]); 
            }
        }
        else {
            for (int i = 0; i < s.length(); i++) {
                printCombinations(digits.substr(1), str + s[i], mapping); 
            }
        }
    }
    
    vector<string> letterCombinations(string digits) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        result.clear(); 
        
        if (digits.length() == 0) {
            result.push_back("");
            return result;  
        }
        
        string mapping[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        printCombinations(digits, "", mapping);
        
        return result; 
    }
};

int main() {
    Solution sln; 
    vector<string> result = sln.letterCombinations("234"); 
    cout << result.size() << endl; 
    for (vector<string>::iterator it = result.begin(); it != result.end(); it++) {
        cout << *it << endl; 
    }
    return 0; 
}
