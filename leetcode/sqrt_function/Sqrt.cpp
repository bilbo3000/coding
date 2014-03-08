#include <iostream> 

using namespace std; 

class Solution {
public:
    int sqrt(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (x <= 0) {
            return 0; 
        }
        
        if (x == 1) {
            return 1; 
        }
        
        long long left = 0; 
        long long right = x; 
        
        while (left <= right) {
            long long mid = (left + right) / 2; 
            
            if (mid * mid == x) {
                return mid; 
            }
            else if (mid * mid < x) {
                left = mid + 1; 
            }
            else {
                right = mid - 1; 
            }
        }
        
        return right; 
    }
};

int main() {
	Solution sln; 
	cout << sln.sqrt(2) << endl; 
	return 0; 
}
