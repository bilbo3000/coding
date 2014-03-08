#include <iostream> 

using namespace std; 

class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        if (*s == '\0' && *p == '\0') return true; 
        if (*s != '\0' && *p == '\0') return false; 
        if (*s == '\0' && *p != '\0' && *p != '*') return false; 
        
        if (*p == '*') {
        	while (*p == '*') {
        		p++; 
        	}
        	p--; 
        	
        	bool result = isMatch(s, p + 1);  // Skip 
        	
        	if (!result && *s != '\0') { 
        		result = isMatch(s + 1, p);  // Match  
        	}
        	
            return result; 
        }
        else {
            if (*p != '?') {
                if (*s == *p) return isMatch(s + 1, p + 1); 
                else return false; 
            }
            else {
                if (*s == '\0') return false; 
                else return isMatch(s + 1, p + 1); 
            }
        }
    }
};

int main() {
	Solution sln; 
	// "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"
	char *s = "aa"; 
	char *p = "*"; 
	if (sln.isMatch(s, p)) cout << "yes" << endl;
	else cout << "no" << endl; 
	return 0; 
}