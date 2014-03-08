#include <iostream> 

using namespace std; 

class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        
        if (n == 0) {
            return; 
        }
        
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                A[i] = B[i]; 
            }
        }
        
        int C[m + n]; 
        int i = 0; 
        int j = 0; 
        int k = 0; 
        
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                C[k] = A[i]; 
                i++; 
            }
            else {
                C[k] = B[j]; 
                j++; 
            }
            
            k++; 
        }
        
        if (i == m) {  // A is done, copy rest of B
            while (j < n) {
                C[k] = B[j]; 
                j++; 
                k++; 
            }
        }
        else if (j == n){  // B is done, copy rest of A
            while (i < m) {
                C[k] = A[i]; 
                i++; 
                k++; 
            }
        }
        
        for (int i = 0; i < (m + n); i++) {
            A[i] = C[i]; 
        }
    }
};

// Test driver
int main() {
    int A[3] = {1, 4, 7};
    int B[4] = {2, 3, 5, 6}; 
    Solution sln; 
    sln.merge(A, 3, B, 4);  
    
    for (int i = 0; i < 7; i++) {
        cout << A[i] << " "; 
    }
    
    return 0; 
}
