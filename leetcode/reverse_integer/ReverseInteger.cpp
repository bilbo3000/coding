#include <iostream> 
#include <cmath> 

using namespace std; 

class Solution {
public:
    int reverse(int x) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (x == 0) {
            return x; 
        }
        
        bool isNeg = false; 
        if (x < 0) {
            isNeg = true; 
        }
        
        int y = abs(x); 
        long long result = 0; 
        
        while (y > 0) {
            int digit = y % 10; 
            y = y / 10; 
            result = result * 10 + digit; 
        }
        
        return isNeg? -result : result; 
    }
};

// Test driver
int main() {
    Solution sln; 
    cout << sln.reverse(0) << endl; 
    cout << sln.reverse(100) << endl; 
    cout << sln.reverse(123) << endl;
    cout << sln.reverse(-123) << endl;  
    return 0; 
}
