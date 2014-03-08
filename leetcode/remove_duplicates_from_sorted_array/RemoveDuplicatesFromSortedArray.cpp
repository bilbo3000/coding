class Solution {
public:
    int removeDuplicates(int A[], int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (n == 0 || n == 1) {
            return n; 
        }
        
        int i = 1;
        while (i < n) {
            if (A[i] == A[i - 1]) {
                for (int j = i + 1; j < n; j++) {
                    A[j - 1] = A[j]; 
                }
                n--; 
                i--; 
            }
            
            i++; 
        }
        
        return n; 
    }
};