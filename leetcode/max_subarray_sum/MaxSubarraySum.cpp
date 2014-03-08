class Solution {
public:
    int maxSubArray(int A[], int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (n == 0) {
            return 0; 
        }
        
        int T[n]; // T[i]: max sum ending with A[i]
        T[0] = A[0]; 
        
        for (int i = 1; i < n; i++) {
            T[i] = max(T[i - 1] + A[i], A[i]); 
        }
        
        int max = T[0]; 
        for (int i = 1; i < n; i++) {
            if (T[i] > max) {
                max = T[i]; 
            }
        }
        
        return max; 
    }
};
