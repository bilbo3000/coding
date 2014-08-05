public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int h = m + n - 1; 
        int i = m - 1; 
        int j = n - 1; 
        
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[h] = A[i]; 
                i--; 
            } else {
                A[h] = B[j]; 
                j--; 
            }
            h--; 
        }
        
        while (j >= 0) {
            A[h] = B[j]; 
            j--; 
            h--; 
        }
    }
}
