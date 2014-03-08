#include <iostream> 

using namespace std; 

class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) {
            return false; 
        }
        
        // Find initial divisor to peel off first digit
        int divisor = 1; 
        while (x / divisor >= 10) {
            divisor = divisor * 10; 
        }
        
        while (x > 0) {
            int left = x / divisor; 
            int right = x % 10; 
            
            if (left != right) {
                return false; 
            }
            
            x = x % divisor;  // Peel off left-most digit
            x = x / 10;  // Peel off last digit
            divisor = divisor / 100;  // Shrink divisor
        }
        
        return true; 
    }
};

int main() {
	Solution sln; 
	if (sln.isPalindrome(101)) {
		cout << "true" << endl; 
	}
	else {
		cout << "false" << endl; 
	}
	
	return 0; 
}
