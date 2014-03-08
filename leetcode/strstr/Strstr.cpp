#include <iostream> 

using namespace std; 

class Solution {
public:
    char *strStr(char *haystack, char *needle) {
        if (!*needle) {  // The pattern is empty, return text
            return haystack; 
        }
        
        char * p1 = haystack; 
        char * p1adv = haystack; 
        char * p2 = needle; 
        
        // Get length of needle
        int m = 0; 
        
        while (*p2 != '\0') {
            m++;
            p2++; 
        }        
        
        // Calculate p1adv
        int cnt = 0; 
        while (*p1adv != '\0' && cnt < m - 1) {
            p1adv++; 
            cnt++; 
        }
        
        if (*p1adv == '\0') {
            return '\0'; 
        }
        
        // Try to find substring match
        while (*p1adv != '\0') {
            p2 = needle; 
            
            int i = 0; 
            while (i < m) {
                if (*(p1 + i) != *(p2 + i)) {
                    break; 
                }
                
                i++; 
            }
            
            if (i == m) {  // Find
            	return p1; 
            }
            
            p1++; 
            p1adv++; 
        }
        
        return '\0'; 
    }
};

int main() {
	Solution sln; 
	char * haystack = "aaa"; 
	char * needle = "a"; 
	char * result = sln.strStr(haystack, needle);  
	cout << result << endl; 
	return 0; 
}
