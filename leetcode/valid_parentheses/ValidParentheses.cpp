#include <iostream> 
#include <stack> 

using namespace std; 

class Solution {
public:
    bool isValid(string s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (s.size() == 0) {
            return false; 
        }
        
        stack<char> mystack; 
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
                mystack.push(s[i]); 
            }
            else {
                if (mystack.size() == 0) {
                    return false; 
                }
                
                if (s[i] == ')' && mystack.top() != '(') {
                    return false; 
                }
                
                if (s[i] == '}' && mystack.top() != '{') {
                    return false; 
                }
                
                if (s[i] == ']' && mystack.top() != '[') {
                    return false; 
                }
                
                mystack.pop(); 
            }
        }
        
        if (mystack.size() == 0) {
            return true; 
        }
        else {
            return false; 
        }
    }
};

// Test driver 
int main() {
    Solution sln; 
    if (sln.isValid("({[]})")) {
        cout << "true" << endl; 
    }
    else {
        cout << "false" << endl; 
    }
    return 0; 
}
