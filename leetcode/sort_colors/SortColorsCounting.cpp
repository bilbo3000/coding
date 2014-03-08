class Solution {
public:
    void sortColors(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int ca[3]; 
        for (int i = 0; i < 3; i++) {
            ca[i] = 0; 
        }
        
        for (int i = 0; i < n; i++) {
            int val = A[i]; 
            ca[val]++; 
        }
        
        int k = n - 1;
        
        for (int i = 2; i >= 0; i--) {
            while (ca[i] > 0) {; 
                A[k] = i; 
                ca[i]--; 
                k--; 
            }
        }
    }
};
