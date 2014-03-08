#include <iostream> 

using namespace std; 

class Solution {
public:
    string longestPalindrome(string s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int size = s.size(); 
        if (size == 0 && size == 1) {
            return s; 
        }
        
        bool T[size][size]; 
        
        for (int i = 0; i < size; i++) {
        	for (int j = 0; j < size; j++) {
        		T[i][j] = false; 
        	}
        }
        
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (i == j) {
                    T[i][j] = true; 
                }
                else if (i + 1 == j && s[i] == s[j]) {
                    T[i][j] = true; 
                }
                else {
                    T[i][j] = false; 
                }
            }
        }
        
        for (int i = 2; i < size; i++) {
        	for (int j = i - 2; j >= 0; j--) {
        		if (s[j] == s[i]) {
        			T[j][i] = T[j + 1][i - 1]; 
        		}
        		else {
        			T[j][i] = false; 
        		}
        	}
        }
     /*   
        for (int i = 0; i < size; i++) {
        	for (int j = 0; j < size; j++) {
        		if (T[i][j]) {
        			cout << "true "; 
        		}
        		else {
        			cout << "false "; 
        		}
        	}
        	cout << endl; 
        }
     */   
        int max = 0; 
        int maxi = 0; 
        int maxj = 0; 
        
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (T[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1; 
                        maxi = i; 
                        maxj = j;
                    }
                }
            }
        }
        
        return s.substr(maxi, max); 
    }
};

int main() {
	Solution sln; 
	cout << sln.longestPalindrome("aaabaaaa") << endl; 
	return 0; 
}
