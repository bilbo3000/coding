class Solution {
public:
    int removeElement(int A[], int n, int elem) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int i = 0; 
        while (i < n) {
            if (A[i] == elem) {
                A[i] = A[n - 1]; 
                n--; 
                i--; 
            }
            
            i++; 
        }
        
        return n; 
    }
};
