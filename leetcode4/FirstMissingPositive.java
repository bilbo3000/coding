public class Solution {
    public int firstMissingPositive(int[] A) {
        int len = A.length; 
        int i = 0; 
        
        while (i < len) {
            if (A[i] != i + 1) {
                if (A[i] >= 1 && A[i] <= len && A[A[i] - 1] != A[i]) {
                    swap(A, i, A[i] - 1); 
                    i--; 
                }
            } 
            
            i++; 
        }
        
        int j = 0; 
        while (j < len) {
            if (A[j] != j + 1) {
                return j + 1;
            }
            
            j++; 
        }
        
        return j + 1; 
    }
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i]; 
        A[i] = A[j]; 
        A[j] = temp; 
    }
}
