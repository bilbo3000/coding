#include <iostream> 
#include <vector> 

using namespace std; 

class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        int n = strlen(s); 
        int m = strlen(p); 
        
        vector<bool> currRow(n + 1, false); 
        currRow[n] = true; 
                
        for (int i = m - 1; i >= 0; i--) {
        	vector<bool> prevRow = currRow;
        	currRow.clear(); 
        	
        	for (int j = n - 1; j >= 0; j--) {
        		if (*(p + i) == '?' || *(s + j) == *(p + i)) {
        			currRow[j] = prevRow[j + 1]; 
        		}
        		else {
        			if (*(p + i) == '*') {
        				currRow[j] = prevRow[j] || currRow[j + 1]; 
        			}
        			else {
        				currRow[j] = false;  
        			}
        		}
        	}
        }
        
        return currRow[0]; 
    }
};

int main() {
	Solution sln; 
	// "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"
	char *s = "aa"; 
	char *p = "a*b"; 
	if (sln.isMatch(s, p)) cout << "yes" << endl;
	else cout << "no" << endl; 
	return 0; 
}