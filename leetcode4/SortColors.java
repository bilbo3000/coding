public class Solution {
    public void sortColors(int[] A) {
        int len = A.length; 
        int lastZero = -1; 
        int firstTwo = len; 
        int i = 0; 
        
        while (i < len) {
            if (A[i] == 0) {
                lastZero++; 
                swap(A, lastZero, i); 
            } else if (A[i] == 2) {
                firstTwo--; 
                swap(A, firstTwo, i);
                i--; 
            }
            
            i++; 
            
            if (i >= firstTwo) {
                return; 
            }
        }
    }
    
    private void swap(int[] A, int a, int b) {
        int temp = A[a]; 
        A[a] = A[b]; 
        A[b] = temp; 
    }
}
