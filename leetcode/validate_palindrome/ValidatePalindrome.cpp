#include <iostream> 

using namespace std; 

class Solution {
public:
    bool isChar(char &c) {  
        if (c >= 'A' && c <= 'Z') {
            c += 32; // Convert upper case to lower case
        }
        
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true; 
        }
        
        return false; 
    }
    
    bool isPalindrome(string s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (s.size() == 0 || s.size() == 1) {
            return true; 
        }
        
        int i = 0; 
        int j = s.size() - 1; 
        
        while (i <= j) {
            bool isChar1 = isChar(s[i]);
            bool isChar2 = isChar(s[j]); 
            
            if (isChar1 && isChar2) {
                if (s[i] != s[j]) {
                    return false;    
                } 
                
                i++; 
                j--; 
            }
            else {
                if (!isChar1) {
                    i++; 
                }
                
                if (!isChar2) {
                    j--; 
                }
            }
        }
        
        return true; 
    }
};

// Test driver 
int main() {
    Solution sln; 
    string s = "A man, a plan, a canal: Panama"; 
    if (sln.isPalindrome(s)) {
        cout << "true" << endl; 
    }
    else {
        cout << "false" << endl; 
    }
    
    return 0; 
}
