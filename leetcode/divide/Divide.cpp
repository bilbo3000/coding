#include <iostream> 

using namespace std; 

class Solution {
public:
    int divide(int dividend, int divisor) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        
        if (dividend == 0 || divisor == 0) {
            return 0; 
        }
        
        if (dividend == divisor) {
            return 1; 
        }
        
        int result = 0; 
        
        while (dividend >= divisor) {
            dividend -= divisor; 
            result++; 
        }
        
        return result; 
    }
};

int main() {
	Solution sln; 
	cout << sln.divide(0, 0) << endl; 
	cout << sln.divide(0, 5) << endl; 
	cout << sln.divide(5, 5) << endl; 
	cout << sln.divide(10, 5) << endl; 
	cout << sln.divide(11, 5) << endl;
	cout << sln.divide(14, 5) << endl;  
	cout << sln.divide(15, 5) << endl; 
}