#include <iostream> 

#define INT_MAX 2147483647
#define INT_MIN -2147483648

using namespace std; 

class Solution {
public:
    int atoi(const char *str) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (str == NULL) {
            return 0; 
        }
        
        while (*str == ' ') {
            str++; 
        }
        
        if (*str == '\0') {
            return 0; 
        }
        
        bool isNeg = false; 
        if (*str == '-') {
            isNeg = true; 
            str++; 
        }
        else if (*str == '+') {
            str++; 
        }
        
        long long result = 0; 
        
        while (*str >= '0' && *str <= '9') {
            result = result * 10 + (*str - '0'); 
            str++; 
            
            if (result > INT_MAX) break; 
        }
        
        if (isNeg) {
            result = -result; 
        }
        if (result > INT_MAX) {
            return INT_MAX; 
        }
        else if (result < INT_MIN) {
            return INT_MIN; 
        }
        
        return  (int)result; 
    }
};

int main(){
    char * str = "2147483648"; 
    Solution sln; 
    cout << sln.atoi(str) << endl; 
    return 0; 
}
