public class Solution {
    public void sortColors(int[] A) {
        int len = A.length; 
        int l = -1;   // Last 0
        int r = len;  // First 2
        
        for (int i = 0; i < r; i++) {
            if (A[i] == 0) {
                l++; 
                int temp = A[l]; 
                A[l] = A[i]; 
                A[i] = temp; 
            }
            else if (A[i] == 2) {
                r--; 
                int temp = A[r]; 
                A[r] = A[i]; 
                A[i] = temp; 
                i--; 
            }
        }
    }
}
