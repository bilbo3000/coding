class Solution {
public:
    int trap(int A[], int n) {
        int water = 0; 
        for (int i = 1; i < n - 1; i++) {
            int j = i - 1; 
            int leftmax = A[j]; 
            
            while (j >= 0) {
                if (A[j] > leftmax) {
                    leftmax = A[j]; 
                }
                
                j--; 
            }
            
            int k = i + 1; 
            int rightmax = A[k]; 
            
            while (k < n) {
                if (A[k] > rightmax) {
                    rightmax = A[k]; 
                }
                
                k++; 
            }
            
            int delta = min(leftmax, rightmax) - A[i]; 
            if (delta > 0) {
                water += delta; 
            }
        }
        
        return water; 
    }
};
