#include <iostream> 
#include <vector> 

using namespace std; 

class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        int n = strlen(s); 
        int m = strlen(p); 
        
        vector<bool> currRow(n + 1, false); 
        currRow[0] = true; 
                
        for (int i = 1; i <= m; i++) {
        	vector<bool> prevRow = currRow;
        	currRow.clear(); 
        	
        	for (int j = 1; j <= i + 1; j++) {
        		if (*(p + i - 1) == '?' || *(s + j - 1) == *(p + i - 1)) {
        			currRow[j] = prevRow[j - 1]; 
        		}
        		else {
        			if (*(p + i - 1) == '*') {
        				currRow[j] = prevRow[j] || currRow[j - 1]; 
        			}
        			else {
        				currRow[j] = false;  
        			}
        		}
        	}
        }
        
        return currRow[n]; 
    }
};

int main() {
	Solution sln; 
	// "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"
	char *s = "aa"; 
	char *p = "a*"; 
	if (sln.isMatch(s, p)) cout << "yes" << endl;
	else cout << "no" << endl; 
	return 0; 
}