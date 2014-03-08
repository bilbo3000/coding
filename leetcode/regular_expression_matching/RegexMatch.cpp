#include <iostream> 

using namespace std; 

class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        if (*s == '\0' && *p == '\0') return true; 
        if (*p == '\0' && *s != '\0') return false; 
        if (*s == '\0' && *p != '\0' && *(p + 1) != '*') return false; 
        
        if (*(p + 1) == '*') {  // Next is star
            bool result = isMatch(s, p + 2); // Skip *
            
            if (!result) {
                if (*s == *p || (*s != '\0' && *p == '.')) {
                    result = isMatch(s + 1, p);  // Match one
                } 
            }
            
            return result;  
        }
        else {
            if (*s == *p || *p == '.') return isMatch(s + 1, p + 1);  // match
            else return false; 
        }
    }
};

int main() {
	Solution sln; 
	// "acaabbaccbbacaabbbb", "a*.*b*.*a*aa*a*"
	char *s = "aa"; 
	char *p = "a*"; 
	
	if (sln.isMatch(s, p)) cout << "yes" << endl; 
	else cout << "no" << endl; 
	return 0; 
}
