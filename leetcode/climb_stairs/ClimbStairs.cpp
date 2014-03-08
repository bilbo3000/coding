#include <iostream> 

using namespace std; 

class Solution {
public:
    int climbStairs(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (n == 0) {
            return 0; 
        }
        
        if (n == 1) {
            return 1; 
        }
        
        if (n == 2) {
            return 2;
        }
        
        int T[n];  // T[i]: number of ways to get to step i
        T[0] = 1; 
        T[1] = 2; 
        
        for (int i = 2; i < n; i++) {
            T[i] = T[i - 1] + T[i - 2]; 
        }
        
        return T[n - 1]; 
    }
};

int main() {
    Solution sln; 
    cout << sln.climbStairs(3) << endl; 
    return 0; 
}
