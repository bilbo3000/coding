#include <iostream> 
#include <vector> 
#include <stdlib.h> 

using namespace std; 

class Solution {
public:
    void restoreHelper(string s, string curr, int cnt, int sec, vector<string> &result) {
        if (cnt > s.size() || sec == 4 && cnt < s.size()) {
            return; 
        }
        
        if (s.size() == cnt && sec == 4) {
            result.push_back(curr);
            return; 
        }
        
        if (s.substr(cnt, 1) == "0") {
            if (sec == 3) {
                restoreHelper(s, curr + s.substr(cnt, 1), cnt + 1, sec + 1, result); 
            } 
            else {
                restoreHelper(s, curr + s.substr(cnt, 1) + ".", cnt + 1, sec + 1, result);
            }            
        }
        else {
            for (int i = 0; i < 3; i++) {
                int val = atoi(s.substr(cnt, i + 1).c_str());  
                if (val <= 255 && val >= 0) {
                    if (sec == 3) {
                        restoreHelper(s, curr + s.substr(cnt, i + 1), cnt + i + 1, sec + 1, result); 
                    } 
                    else {
                        restoreHelper(s, curr + s.substr(cnt, i + 1) + ".", cnt + i + 1, sec + 1, result);
                    }
                }
            }
        }
    }
    
    vector<string> restoreIpAddresses(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<string> result; 
        if (s.size() == 0) {
            return result; 
        }
        
        restoreHelper(s, "", 0, 0, result); 
        
        return result; 
    }
};

int main() {
    Solution sln; 
    vector<string> result; 
    result = sln.restoreIpAddresses("010010"); 
    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << " "; 
    }
    return 0; 
}
