public class Solution {
    public void sortColors(int[] A) {
        int len = A.length; 
        int l = -1;  // Last 0
        int r = len;  // First 2
        
        for (int i = 0; i < r; i++) {
            if (A[i] == 0) {
                l++; 
                swap(A, l, i); 
            } else if (A[i] == 2) {
                r--; 
                swap(A, i, r);
                i--; 
            }
        }
    }
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i]; 
        A[i] = A[j]; 
        A[j] = temp; 
    }
}
