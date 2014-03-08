#include <iostream> 
#include <vector> 

using namespace std; 

class Solution {
public:
    bool isMatch(const char *s, const char *p) {
    	const char * prevStar = NULL; 
    	const char * prevS = NULL; 
    	
 		while (*s != '\0') {
 			if (*p == '?' || *s == *p) {  // Match
 				s++; 
 				p++; 
 				continue; 
 			}
 			
 			if (*p == '*') {  // Find a start in pattern
 				prevStar = p; 
 				prevS = s; 
 				p++;  // Try skip '*' and move on
 				continue; 
 			}
 			
 			if (prevStar != NULL) {
 				p = prevStar; 
 				s = prevS + 1; 
 				continue; 
 			}
 			
 			return false; 
 		}
 		
 		while (*p == '*') {
 			p++; 
 		}
 		
 		if (*p == '\0') return true; 
 		return false; 
    }
};

int main() {
	Solution sln; 
	// "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"
	char *s = "aab"; 
	char *p = "c*a*b"; 
	if (sln.isMatch(s, p)) cout << "yes" << endl;
	else cout << "no" << endl; 
	return 0; 
}