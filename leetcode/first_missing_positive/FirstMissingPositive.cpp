#include<iostream> 

using namespace std; 

class Solution {
public:
    void Swap(int &a, int &b) {
        int temp = a; 
        a = b; 
        b = temp; 
    }
    
    int firstMissingPositive(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (n == 0) {
            return 1; 
        }
        
        int i = 0; 
        while(i < n) {
            if (A[i] > 0 &&  // Positive 
                (A[i] - 1) < n &&  // Within range
                i != (A[i] - 1) &&   // Already at right position
                A[i] != A[A[i] - 1])  // Destination already good
            {
                // Put current element at right position 
                Swap(A[i], A[A[i] - 1]); 
                i--; 
            }
            
            i++; 
        }
        
        int j = 0; 
        while (j < n) {
            if (A[j] != (j + 1)) {
                return j + 1; 
            }
            
            j++;
        }
        
        return n + 1;
    }
};

// Test driver 
int main() {
    int A[4] = {3, 4, -1, 1}; 
    Solution sln; 
    cout << sln.firstMissingPositive(A, 4) << endl; 
    return 0; 
}
