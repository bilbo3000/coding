class Solution {
public:
    int jump(int A[], int n) {
        if (n <= 1) {
            return 0; 
        }
        
        int T[n]; 
        for (int i = 0; i < n; i++) {
            T[i] = INT_MAX; 
        }
        
        T[0] = 0; 
        
        // Initialization 
        for (int i = 1; i <= A[0]; i++) {
            T[i] = 1; 
        }
        
        for (int i = A[0] + 1; i < n; i++) {
            int j = i - 1; 
            int min = T[j]; 
            while (j > 0) {
                if (A[j] >= (i - j) && T[j] < min) {
                    min = T[j]; 
                }
                
                j--; 
            }
            
            T[i] = min + 1; 
        }
        
        return T[n - 1]; 
    }
};
